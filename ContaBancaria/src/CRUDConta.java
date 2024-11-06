
import Exceptions.ContaInexistenteException;


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
            PreparedStatement ps = con.prepareStatement("INSERT INTO tb_conta (numero, titular, saldo, limite) " +
                    "VALUES (?, ?, ?, ?)");

            ps.setInt(1, conta.getNumero());
            ps.setString(2, conta.getTitular());
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
                String nome = rs.getString("titular");
                double saldo = rs.getDouble("saldo");
                double limite = rs.getDouble("limite");
                return new Conta(num, nome, saldo, limite);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        throw new ContaInexistenteException();
    }

    public List<Conta> readAll(int numero) {
        List<Conta> contas = new ArrayList<>();
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_conta " +
                    "WHERE numero = ?");
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("numero");
                String nome = rs.getString("titular");
                double saldo = rs.getDouble("saldo");
                double limite = rs.getDouble("limite");
                contas.add(new Conta(num, nome, saldo, limite));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        throw new ContaInexistenteException();
    }

    public void update(String titular, int novoNumero, double novoLimite) {
        try (Connection con = banco.getConexao()) {
            PreparedStatement ps = con.prepareStatement("UPDATE tb_conta " +
                    "SET numero = ?, limite = ? " +
                    "WHERE titular = ?");
            ps.setInt(1, novoNumero);
            ps.setDouble(2, novoLimite);
            ps.setString(3, titular);
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