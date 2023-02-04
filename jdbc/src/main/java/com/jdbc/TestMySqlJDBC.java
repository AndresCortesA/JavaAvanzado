package com.jdbc;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class TestMySqlJDBC {

    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test";
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Id: " + resultado.getInt("id_persona"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Apellido: " + resultado.getString("apellido"));
                System.out.println("Email: " + resultado.getString("email"));
                System.out.println("Telefono: " + resultado.getString("telefono"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
