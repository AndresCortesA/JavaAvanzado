package com.usuario.jdbc.vista;

import java.util.List;

import com.usuario.jdbc.datos.UsuarioDAO;
import com.usuario.jdbc.domain.Usuario;

public class VistaUsuarios {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // insertar
        Usuario insertarUser = new Usuario("Perezita", "245");
        dao.insertar(insertarUser);

        // actualizar
        // Usuario actualizarUser = new Usuario(2, "Palomita", "2324");
        // dao.actualizar(actualizarUser);

        // eliminar
        // Usuario eliminarUser = new Usuario(2);
        // dao.eliminar(eliminarUser);

        // consultar
        List<Usuario> usuarios = dao.listarUsuarios();
        usuarios.forEach(usuario -> System.out.println(usuario.toString()));

    }
}
