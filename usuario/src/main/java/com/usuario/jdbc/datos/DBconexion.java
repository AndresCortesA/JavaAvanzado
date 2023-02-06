package com.usuario.jdbc.datos;

import java.sql.*;

public class DBconexion {
    private static final String DBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DBC_USUARIO = "root";
    private static final String DBC_CLAVE = "admin";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(DBC_URL, DBC_USUARIO, DBC_CLAVE);
    }

    // Cerrar conexiones
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void close(Connection cn) throws SQLException {
        cn.close();
    }
}
