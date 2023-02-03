package peliculas.servicio;

import peliculas.datos.*;
import peliculas.domain.Pelicula;
import peliculas.exepciones.*;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImplementar();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexarIfoArchivo = false;
        try {
            anexarIfoArchivo = datos.Existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexarIfoArchivo);
        } catch (AccesoDatosExcepciones e) {
            System.out.println("Error para acceso del archivo");
            e.printStackTrace(System.out);
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("Pelicula: " + pelicula);
            }
        } catch (LecturaDatosExcepciones e) {
            System.out.println("Error para acceso del archivo");
            e.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosExcepciones e) {
            System.out.println("Error para acceso del archivo");
            e.printStackTrace(System.out);
        }
        System.out.println("resultado: " + resultado);

    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.Existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosExcepciones e) {
            System.out.println("Error para acceso del archivo");
            e.printStackTrace(System.out);
        }
    }

}
