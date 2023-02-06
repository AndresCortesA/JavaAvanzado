package jdbc.manejo.vista;

import java.util.List;

import jdbc.manejo.datos.PersonaDAO;
import jdbc.manejo.domain.Persona;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO dao = new PersonaDAO();
        // Insertar
        Persona personaInsertar = new Persona("Mario Elias", "Marino", "corri@mail.com",
                "34345567");
        dao.insertar(personaInsertar);
        // Actualizar
        Persona personaAcualizar = new Persona(3, "Elias", "Marino", "corri@mail.com", "34345567");
        dao.actualizar(personaAcualizar);

        // eliminar
        // Persona personaEliminar = new Persona(3);
        // dao.eliminar(personaEliminar);

        // consultar
        List<Persona> personas = dao.seleccionar();
        personas.forEach(persona -> System.out.println(persona.toString()));

    }
}
