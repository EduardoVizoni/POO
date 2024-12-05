import Exceptions.ClienteInvalidoException;
import Exceptions.ClienteNaoEncontradoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD {

    private static final String TABLE_NAME = "cliente";

    public void cadastrarCliente(Cliente cliente) throws ClienteInvalidoException {
        String sql = "INSERT INTO " + TABLE_NAME +
                " (nome, email, telefone) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ClienteInvalidoException("Erro ao cadastrar cliente.", e);
        }
    }

    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public Cliente buscarClientePorId(int id) throws ClienteNaoEncontradoException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("telefone")
                    );
                } else {
                    throw new ClienteNaoEncontradoException("Cliente não encontrado.");
                }
            }
        } catch (SQLException e) {
            throw new ClienteNaoEncontradoException("Erro ao buscar cliente.");
        }
    }

    public void atualizarCliente(Cliente cliente) throws ClienteInvalidoException {
        String sql = "UPDATE " + TABLE_NAME +
                " SET nome = ?, email = ?, telefone = ? WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());

            if (stmt.executeUpdate() == 0) {
                throw new ClienteInvalidoException("Nenhuma linha foi alterada. Verifique o ID.");
            }
        } catch (SQLException e) {
            throw new ClienteInvalidoException("Erro ao atualizar cliente.", e);
        }
    }

    public void removerCliente(int id) throws ClienteNaoEncontradoException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            if (stmt.executeUpdate() == 0) {
                throw new ClienteNaoEncontradoException("Cliente não encontrado para remoção.");
            }
        } catch (SQLException e) {
            throw new ClienteNaoEncontradoException("Erro ao remover cliente.");
        }
    }
}