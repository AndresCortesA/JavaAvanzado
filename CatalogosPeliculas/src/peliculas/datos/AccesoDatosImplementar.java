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

        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexarIfoArchivo));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito correctamente " + pelicula);

        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosExcepciones("Problema para escribir pelicula: " + e.getMessage());
        }

    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepciones {
        var archivo = new File(nombreRecurso);
        // si no se encuentra la pelicula no guardamos nada
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula: " + linea + " encontrada en la posicion: " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosExcepciones("Problema para encontrar la pelicula: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosExcepciones("Problema para encontrar la pelicula: " + e.getMessage());
        }

        // pero si se encuentra retornamos el resultado
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosExcepciones {
        var archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se creo correctamente");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosExcepciones("Problema para crear el archivo: " + e.getMessage());
        }

    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosExcepciones {
        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se borro el archivo correctamente");

    }

}
