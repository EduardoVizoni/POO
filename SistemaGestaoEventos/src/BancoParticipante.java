import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoParticipante {

    private List<Participante> participantes;
    private BancoDeDados banco;

    public BancoParticipante() {
        participantes = new ArrayList<>();
        banco = new BancoDeDados();
    }

    public void adicionarParticipante(Participante participante) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO participantes (id, nome, email) VALUES (?, ?, ?)");
            ps.setInt(1, participante.getId());
            ps.setString(2, participante.getNome());
            ps.setString(3, participante.getEmail());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Participante buscarParticipantePorEmail(String email) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM participantes WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String emailPesquisa = rs.getString("email");
                return new Participante(id, nome, emailPesquisa);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void removerParticipante(Participante participante) {
        try(Connection con = banco.getConexao()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM participantes WHERE id = ?");
            ps.setInt(1, participante.getId());
            ps.execute();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public List<Participante> getParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM participantes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                participantes.add(new Participante(id, nome, email));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return participantes;
    }
}