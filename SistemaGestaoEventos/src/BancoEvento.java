import Exceptions.EventoJaCadastradoException;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoEvento {

    private List<Evento> eventos;
    private BancoDeDados banco;

    public BancoEvento() {
        this.eventos = new ArrayList<>();
        this.banco = new BancoDeDados();
    }

    public void cadastrarEvento(int eventoId, String nome, String local, String data, String descricao) throws EventoJaCadastradoException {
        try (Connection con = banco.getConexao()) {
            PreparedStatement consulta = con.prepareStatement("SELECT * FROM eventos WHERE nome = ? AND local = ? AND data = ?");
            consulta.setString(1, nome);
            consulta.setString(2, local);
            consulta.setString(3, data);
            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                throw new EventoJaCadastradoException("O evento com este nome, local e data já foi cadastrado.");
            } else {
                PreparedStatement insercao = con.prepareStatement("INSERT INTO eventos (nome, local, data, descricao) VALUES (?, ?, ?, ?)");
                insercao.setString(1, nome);
                insercao.setString(2, local);
                insercao.setString(3, data);
                insercao.setString(4, descricao);
                insercao.executeUpdate();
                System.out.println("Evento cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }

    public void adicionarEvento(Evento evento) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO eventos (nome, local, data, descricao) VALUES (?,?,?,?)");
            ps.setString(1, evento.getNome());
            ps.setString(2, evento.getLocal());
            ps.setString(3, evento.getData());
            ps.setString(4, evento.getDescricao());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Evento buscarEventoPorNome(String nome) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM eventos WHERE nome = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nomeEvento = rs.getString("nome");
                String localEvento = rs.getString("local");
                String dataEvento = rs.getString("data");
                String descricaoEvento = rs.getString("descricao");
                return new Evento(id, nomeEvento, localEvento, dataEvento, descricaoEvento);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    public void removerEvento(Evento evento) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM eventos WHERE id = ?");
            ps.setInt(1, evento.getId());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Evento> getEventos() {
        List<Evento> eventos = new ArrayList<>();
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM eventos");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String local = rs.getString("local");
                String data = rs.getString("data");
                String descricao = rs.getString("descricao");
                eventos.add(new Evento(id, nome, local, data, descricao));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return eventos;
    }
}