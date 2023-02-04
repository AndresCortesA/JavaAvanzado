package jdbc.manejo.vista;

import java.util.List;

import jdbc.manejo.datos.PersonaDAO;
import jdbc.manejo.domain.Persona;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO dao = new PersonaDAO();
        List<Persona> personas = dao.seleccionar();
        personas.forEach(persona -> System.out.println(persona.toString()));

    }
}
