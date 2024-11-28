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