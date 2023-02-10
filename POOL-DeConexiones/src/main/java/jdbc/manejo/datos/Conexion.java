package jdbc.manejo.datos;

import java.sql.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String JDBC_USUARIO = "root";
    private static final String JDBC_PASSWORD = "admin";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USUARIO);
            dataSource.setPassword(JDBC_PASSWORD);
            // Inicializamos el tamaño del pool de conexiones, el tamaño no debe ser muy
            // grande en esta practica
            // consume muchos recursos
            dataSource.setInitialSize(50);
        }

        return dataSource;

    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
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
