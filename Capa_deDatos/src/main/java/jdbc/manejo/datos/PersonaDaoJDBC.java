package jdbc.manejo.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbc.manejo.domain.PersonaDTO;
import static jdbc.manejo.datos.Conexion.*;

public class PersonaDaoJDBC implements IPersonaDAO {
    // DAO - DATA ACCESS OBJECT
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    // Data
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rSet = null;
    PersonaDTO persona = null;
    int registros = 0;

    public PersonaDaoJDBC() {

    }

    public PersonaDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<PersonaDTO> SELECT() throws SQLException {
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            ps = conexion.prepareStatement(SQL_SELECT);
            rSet = ps.executeQuery();
            while (rSet.next()) {
                int idPersona = rSet.getInt("id_persona");
                String nombre = rSet.getString("nombre");
                String apellido = rSet.getString("apellido");
                String email = rSet.getString("email");
                String telefono = rSet.getString("telefono");

                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);

                personas.add(persona);

            }
        } finally {
            try {
                close(rSet);
                close(ps);
                if (this.conexionTransaccional == null) {
                    close(conexion);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int INSERT(PersonaDTO persona) throws SQLException {
        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
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

    public int UPDATE(PersonaDTO persona) throws SQLException {
        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            ps.setInt(5, persona.getIdPersona());

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

    public int DELETE(PersonaDTO persona) throws SQLException {
        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, persona.getIdPersona());
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
