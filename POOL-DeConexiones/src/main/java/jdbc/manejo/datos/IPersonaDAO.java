package jdbc.manejo.datos;

import java.sql.SQLException;
import java.util.List;

import jdbc.manejo.domain.PersonaDTO;

public interface IPersonaDAO {

    List<PersonaDTO> SELECT() throws SQLException;

    public int INSERT(PersonaDTO persona) throws SQLException;

    public int UPDATE(PersonaDTO persona) throws SQLException;

    public int DELETE(PersonaDTO persona) throws SQLException;

}
