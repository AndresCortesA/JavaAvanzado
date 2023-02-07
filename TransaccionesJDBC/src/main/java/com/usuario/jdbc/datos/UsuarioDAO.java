package com.usuario.jdbc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.usuario.jdbc.domain.*;
import static com.usuario.jdbc.datos.DBconexion.*;

public class UsuarioDAO {

    /*
     * En el manejo de transacciones nos encargaremos de el flujo de nuestra base de
     * datos
     * manejando los commits y rollbacks que en esta hagamos
     * debemos tener en cuenta los autocommits ´getAutoCommit()' que realicemos ya
     * que por defecto esta se encuentra en true
     * para que no se nos salga de las manos el manejo de estos datos la iniciamos
     * en false
     */

    // DATA ACCESS OBJECT

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (nombre_usuario, clave_usuario) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre_usuario =?, clave_usuario =? WHERE id_usuario =?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario =?";

    // DATA
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Usuario usuario = null;
    int registros = 0;

    public UsuarioDAO() {

    }

    public UsuarioDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : conectar();
            ps = conexion.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String clave_usuario = rs.getString("clave_usuario");

                usuario = new Usuario(id_usuario, nombre_usuario, clave_usuario);
                usuarios.add(usuario);
            }
        } finally {
            try {
                close(rs);
                close(ps);
                if (this.conexionTransaccional == null) {
                    close(conexion);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return usuarios;

    }

    public int insertar(Usuario usuario) throws SQLException {

        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : conectar();
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getClave_usuario());
            registros = ps.executeUpdate();
        } finally {
            try {
                close(ps);
                if (this.conexionTransaccional == null) {
                    close(conexion);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int actualizar(Usuario usuario) throws SQLException {
        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : conectar();
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getClave_usuario());
            ps.setInt(3, usuario.getId_usuario());
            registros = ps.executeUpdate();
        } finally {
            try {
                close(ps);
                if (this.conexionTransaccional == null) {
                    close(conexion);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int eliminar(Usuario usuario) throws SQLException {
        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : conectar();
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, usuario.getId_usuario());
            registros = ps.executeUpdate();
        } finally {
            try {
                close(ps);
                if (this.conexionTransaccional == null) {
                    close(conexion);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }

}
