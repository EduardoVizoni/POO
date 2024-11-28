import Exceptions.InscricaoJaExistenteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoInscricao {

    private List<Inscricao> inscricoes;
    private BancoDeDados banco;

    public BancoInscricao() {
        inscricoes = new ArrayList<>();
        banco = new BancoDeDados();
    }

    public void inscreverParticipantes(int eventoId, int participanteId) throws InscricaoJaExistenteException {
        try (Connection con = banco.getConexao()) {
            PreparedStatement consulta = con.prepareStatement("SELECT * FROM inscricoes WHERE id_evento = ? AND id_participante = ?");
            consulta.setInt(1, eventoId);
            consulta.setInt(2, participanteId);
            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                throw new InscricaoJaExistenteException("Este participante já está inscrito neste evento.");
            } else {
                PreparedStatement insercao = con.prepareStatement("INSERT INTO inscricoes (id_evento, id_participante) VALUES (?, ?)");
                insercao.setInt(1, eventoId);
                insercao.setInt(2, participanteId);
                insercao.executeUpdate();
                System.out.println("Participante inscrito com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
    }


    // Método para remover uma inscrição
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