import Exceptions.ContaInexistenteException;
import com.mysql.cj.protocol.x.ContinuousOutputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDConta {

    private final BancoDeDados banco = new BancoDeDados();

    public void create(Conta conta) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tb_conta (numero, id_cliente, saldo, limite) " +
                    "VALUES (?, ?, ?, ?)");

            ps.setInt(1, conta.getNumero());
            ps.setInt(2, conta.getTitular().getId());
            ps.setDouble(3, conta.getSaldo());
            ps.setDouble(4, conta.getLimite());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Conta readOne(int numero) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_conta " +
                    "WHERE numero = ?");
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt("numero");
                int idCliente = rs.getInt("id_cliente");
                double saldo = rs.getDouble("saldo");
                double limite = rs.getDouble("limite");
                CRUDCliente crudCliente = new CRUDCliente();
                Cliente titularCliente = crudCliente.readOne(idCliente);
                return new Conta(num, titularCliente, saldo, limite);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        throw new ContaInexistenteException();
    }

    public List<Conta> readAll() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM tb_conta";
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_conta");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("numero");
                int idCliente = rs.getInt("id_cliente");
                double saldo = rs.getDouble("saldo");
                double limite = rs.getDouble("limite");
                CRUDCliente crudCliente = new CRUDCliente();
                Cliente titularCliente = crudCliente.readOne(rs.getInt("id_cliente"));
                contas.add(new Conta(num, titularCliente, saldo, limite));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar contas: " + e.getMessage());
        }
        return contas;
    }

    public void update(Conta conta) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("UPDATE tb_conta " +
                    "SET id_cliente = ?, saldo = ?, limite = ?" +
                    "WHERE numero = ?");
            ps.setInt(1, conta.getTitular().getId());
            ps.setDouble(2, conta.getSaldo());
            ps.setDouble(3, conta.getLimite());
            ps.setInt(4, conta.getNumero());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(int numero) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_conta " +
                    "WHERE numero = ?");
            ps.setInt(1, numero);
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}