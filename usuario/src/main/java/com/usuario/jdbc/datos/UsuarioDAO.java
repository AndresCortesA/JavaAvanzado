package com.usuario.jdbc.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.usuario.jdbc.domain.*;
import static com.usuario.jdbc.datos.DBconexion.*;

public class UsuarioDAO {
    // DATA ACCESS OBJECT
    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (nombre_usuario, clave_usuario) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre_usuario =?, clave_usuario =? WHERE id_usuario =?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario =?";

    public List<Usuario> listarUsuarios() {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conexion = conectar();
            ps = conexion.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String clave_usuario = rs.getString("clave_usuario");

                usuario = new Usuario(id_usuario, nombre_usuario, clave_usuario);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(rs);
                close(ps);
                close(conexion);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace(System.out);
            }
        }

        return usuarios;

    }

    public int insertar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conexion = conectar();
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getClave_usuario());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(ps);
                close(conexion);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int actualizar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conexion = conectar();
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getClave_usuario());
            ps.setInt(3, usuario.getId_usuario());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(ps);
                close(conexion);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int eliminar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conexion = conectar();
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, usuario.getId_usuario());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(ps);
                close(conexion);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return registros;
    }

}
