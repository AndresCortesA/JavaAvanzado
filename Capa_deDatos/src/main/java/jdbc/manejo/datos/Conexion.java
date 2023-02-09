package jdbc.manejo.datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String JDBC_USUARIO = "root";
    private static final String JDBC_PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_PASSWORD);
    }

    public static void close(ResultSet rSet) throws SQLException {
        rSet.close();
    }

    public static void close(Statement st) throws SQLException {
        st.close();
    }

    public static void close(PreparedStatement st) throws SQLException {
        st.close();
    }

    public static void close(Connection con) throws SQLException {
        con.close();
    }
}
