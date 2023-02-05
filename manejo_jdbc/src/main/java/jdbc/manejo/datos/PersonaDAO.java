package jdbc.manejo.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbc.manejo.domain.Persona;
import static jdbc.manejo.datos.Conexion.*;

public class PersonaDAO {
    // DAO - DATA ACCESS OBJECT
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";

    public List<Persona> seleccionar() {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conexion = getConnection();
            ps = conexion.prepareStatement(SQL_SELECT);
            rSet = ps.executeQuery();
            while (rSet.next()) {
                int idPersona = rSet.getInt("id_persona");
                String nombre = rSet.getString("nombre");
                String apellido = rSet.getString("apellido");
                String email = rSet.getString("email");
                String telefono = rSet.getString("telefono");

                persona = new Persona(idPersona, nombre, apellido, email, telefono);

                personas.add(persona);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(rSet);
                close(ps);
                close(conexion);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int insertar(Persona persona) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conexion = getConnection();
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
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
