package peliculas.datos;

import java.util.List;

import peliculas.domain.Pelicula;
import peliculas.exepciones.*;
import peliculas.exepciones.LecturaDatosExcepciones;
/*
 * Aqui solo definimos el comportamiento de los recursos
 */

public interface AccesoDatosIF {
    boolean Existe(String nombreRecurso) throws AccesoDatosExcepciones;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcepciones;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexarIfoArchivo) throws EscrituraDatosExcepciones;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepciones;

    void crear(String nombreRecurso) throws AccesoDatosExcepciones;

    void borrar(String nombreRecurso) throws AccesoDatosExcepciones;
}
