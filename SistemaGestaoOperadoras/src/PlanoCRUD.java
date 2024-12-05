import Exceptions.PlanoInvalidoException;
import Exceptions.PlanoNaoEncontradoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanoCRUD {

    private static final String TABLE_NAME = "plano";

    public void cadastrarPlano(Plano plano) throws PlanoInvalidoException {
        String sql = "INSERT INTO " + TABLE_NAME +
                " (operadora, nome, quantidade_dados, quantidade_dados_bonus, beneficios, valor) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, plano.getOperadora());
            stmt.setString(2, plano.getNome());
            stmt.setDouble(3, plano.getQuantidadeDados());
            stmt.setDouble(4, plano.getQuantidadeDadosBonus());
            stmt.setString(5, plano.getBeneficios());
            stmt.setDouble(6, plano.getValor());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PlanoInvalidoException("Erro ao cadastrar plano.");
        }
    }

    public List<Plano> listarPlanos() throws SQLException {
        List<Plano> planos = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Plano plano = new Plano(
                        rs.getInt("id"),
                        rs.getString("operadora"),
                        rs.getString("nome"),
                        rs.getDouble("quantidade_dados"),
                        rs.getDouble("quantidade_dados_bonus"),
                        rs.getString("beneficios"),
                        rs.getDouble("valor")
                );
                planos.add(plano);
            }
        }
        return planos;
    }

    public Plano buscarPlanoPorId(int id) throws PlanoNaoEncontradoException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Plano(
                            rs.getInt("id"),
                            rs.getString("operadora"),
                            rs.getString("nome"),
                            rs.getDouble("quantidade_dados"),
                            rs.getDouble("quantidade_dados_bonus"),
                            rs.getString("beneficios"),
                            rs.getDouble("valor")
                    );
                } else {
                    throw new PlanoNaoEncontradoException("Plano não encontrado.");
                }
            }
        } catch (SQLException e) {
            throw new PlanoNaoEncontradoException("Erro ao buscar plano.");
        }
    }

    public void atualizarPlano(Plano plano) throws PlanoInvalidoException {
        String sql = "UPDATE " + TABLE_NAME +
                " SET operadora = ?, nome = ?, quantidade_dados = ?, quantidade_dados_bonus = ?, beneficios = ?, valor = ? " +
                "WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, plano.getOperadora());
            stmt.setString(2, plano.getNome());
            stmt.setDouble(3, plano.getQuantidadeDados());
            stmt.setDouble(4, plano.getQuantidadeDadosBonus());
            stmt.setString(5, plano.getBeneficios());
            stmt.setDouble(6, plano.getValor());
            stmt.setInt(7, plano.getId());

            if (stmt.executeUpdate() == 0) {
                throw new PlanoInvalidoException("Nenhuma linha foi alterada. Verifique o ID.");
            }
        } catch (SQLException e) {
            throw new PlanoInvalidoException("Erro ao atualizar plano.");
        }
    }

    public void removerPlano(int id) throws PlanoNaoEncontradoException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            if (stmt.executeUpdate() == 0) {
                throw new PlanoNaoEncontradoException("Plano não encontrado para remoção.");
            }
        } catch (SQLException e) {
            throw new PlanoNaoEncontradoException("Erro ao remover plano.");
        }
    }
}