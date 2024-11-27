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
            PreparedStatement ps = con.prepareStatement("INSERT INTO eventos (id, nome, local, data, descricao) " +
                    "VALUES (?,?,?,?,?);");
            ps.setInt(1, evento.getId());
            ps.setString(2, evento.getNome());
            ps.setString(3, evento.getLocal());
            ps.setString(4, evento.getData());
            ps.setString(5, evento.getDescricao());
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
}