package com.usuario.jdbc.vista;

import java.sql.*;
import java.util.List;

import com.usuario.jdbc.datos.*;
import com.usuario.jdbc.domain.Usuario;

public class VistaUsuarios {
    public static void main(String[] args) {
        /*
         * nota: lo que más nos interesa de las transacciones es crear la consulta de
         * los datos que
         * modifiquen la base de datos
         * 
         * manejaremos la conexion a la base de datos desde fuera
         * el autocommit lo manejamos desde fuera para que no se agregue automaticamente
         */

        Connection conexion = null;
        try {
            conexion = DBconexion.conectar();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            UsuarioDAO dao = new UsuarioDAO(conexion);

            // UPDATE
            Usuario actualizarPersona = new Usuario(8, "Carlos Parza", "123568");
            dao.actualizar(actualizarPersona);

            // INSERT
            Usuario nuevoUsuario = new Usuario("Juan Perez", "215685677457546745674564564");
            dao.insertar(nuevoUsuario);

            conexion.commit();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("ROLLBACK.......................................");
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace(System.out);
            }

        }

    }
}
