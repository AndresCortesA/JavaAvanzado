package jdbc.manejo.vista;

import java.sql.*;
import java.util.List;

import jdbc.manejo.datos.*;
import jdbc.manejo.domain.PersonaDTO;

public class TestManejoPersonas {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            IPersonaDAO dao = new PersonaDaoJDBC(conexion);

            // UPDATE
            // PersonaDTO actualizarPersona = new PersonaDTO(1, "Juan", "Parza",
            // "mail@mail.com", "12455783");
            // dao.UPDATE(actualizarPersona);

            // INSERT
            // PersonaDTO nuevoUsuario = new PersonaDTO("Camila", "Paez", "mail@mail.com",
            // "45564566");
            // dao.INSERT(nuevoUsuario);

            // SELECT
            List<PersonaDTO> listarPersonas = dao.SELECT();
            listarPersonas.forEach(personas -> System.out.println(personas.toString()));

            conexion.commit();
            System.out.println("Commit exitoso.......................");

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
