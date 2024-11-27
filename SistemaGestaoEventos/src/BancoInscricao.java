import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoInscricao {

    private List<Inscricao> inscricoes;
    private List<Participante> participantes;
    private BancoDeDados banco;

    public BancoInscricao() {
        inscricoes = new ArrayList<>();
        participantes = new ArrayList<>();
        banco = new BancoDeDados();
    }

    public void inscreverParticipantes(int eventoId, int participanteId) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement consulta = con.prepareStatement("SELECT * FROM inscricoes WHERE id_evento = ? AND id_participante = ?");
            PreparedStatement insercao = con.prepareStatement("INSERT INTO inscricoes (id_evento, id_participante) VALUES (?,?)");
            consulta.setInt(1, eventoId);
            consulta.setInt(2, participanteId);
            ResultSet rs = consulta.executeQuery();
            if (!rs.next()) {
                insercao.setInt(1, eventoId);
                insercao.setInt(2, participanteId);
                insercao.executeUpdate();
                System.out.println("Participante inserido com sucesso!");
            } else {
                System.out.println("Participante já está inscrito neste evento");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void removerInscricao(int id) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM inscricoes WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}