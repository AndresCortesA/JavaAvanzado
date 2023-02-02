package peliculas.datos;

import java.io.*;
import java.util.*;

import peliculas.domain.Pelicula;
import peliculas.exepciones.*;

public class AccesoDatosImplementar implements IAccesoDatos {

    /*
     * Nota:
     * aqui se implementaran los metodos no se sobreescribiran como tal, solo que la
     * libreria que maneja java las cosidera como @Override
     */

    @Override
    public boolean Existe(String nombreRecurso) throws AccesoDatosExcepciones {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcepciones {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();

            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosExcepciones("Problema para listar: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosExcepciones("Problema para listar: " + e.getMessage());
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexarIfoArchivo)
            throws EscrituraDatosExcepciones {

    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepciones {
        return null;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosExcepciones {

    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosExcepciones {

    }

}
