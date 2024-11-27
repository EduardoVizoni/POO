import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private final String URL = "jdbc:mysql://localhost:3306/sistemagestaoeventos?createDatabaseIfNotExist=true";
    private final String USER = "root";
    private final String PASSWORD = "";

    public Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}