import Exceptions.ServicoAdicionalInvalidoException;
import Exceptions.ServicoAdicionalNaoEncontradoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoAdicionalCRUD {

    private static final String TABLE_NAME = "servico_adicional";

    public void cadastrarServico(ServicoAdicional servico) throws ServicoAdicionalInvalidoException {
        String sql = "INSERT INTO " + TABLE_NAME +
                " (nome, descricao, valor) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getCustoMensal());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ServicoAdicionalInvalidoException("Erro ao cadastrar serviço adicional.", e);
        }
    }

    public List<ServicoAdicional> listarServicos() throws SQLException {
        List<ServicoAdicional> servicos = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ServicoAdicional servico = new ServicoAdicional(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("valor")
                );
                servicos.add(servico);
            }
        }
        return servicos;
    }

    public ServicoAdicional buscarServicoPorId(int id) throws ServicoAdicionalNaoEncontradoException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ServicoAdicional(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getDouble("valor")
                    );
                } else {
                    throw new ServicoAdicionalNaoEncontradoException("Serviço adicional não encontrado.");
                }
            }
        } catch (SQLException e) {
            throw new ServicoAdicionalNaoEncontradoException("Erro ao buscar serviço adicional.");
        }
    }

    public void atualizarServico(ServicoAdicional servico) throws ServicoAdicionalInvalidoException {
        String sql = "UPDATE " + TABLE_NAME +
                " SET nome = ?, descricao = ?, valor = ? WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getCustoMensal());
            stmt.setInt(4, servico.getId());

            if (stmt.executeUpdate() == 0) {
                throw new ServicoAdicionalInvalidoException("Nenhuma linha foi alterada. Verifique o ID.");
            }
        } catch (SQLException e) {
            throw new ServicoAdicionalInvalidoException("Erro ao atualizar serviço adicional.", e);
        }
    }

    public void removerServico(int id) throws ServicoAdicionalNaoEncontradoException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            if (stmt.executeUpdate() == 0) {
                throw new ServicoAdicionalNaoEncontradoException("Serviço adicional não encontrado para remoção.");
            }
        } catch (SQLException e) {
            throw new ServicoAdicionalNaoEncontradoException("Erro ao remover serviço adicional.");
        }
    }
}
