package peliculas.vista;

import java.util.Scanner;

import peliculas.servicio.*;

public class CatalogoPeliculasPresentacionMain {
    public static void main(String[] args) {
        var opciones = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opciones != 0) {
            System.out.println("Elige una opcion: \n" +
                    "1. Iniciar catalogo peliculas \n" +
                    "2. Agregar pelicula a catalogo \n" +
                    "3. Listar pelicula de catalogo \n" +
                    "4. Buscar pelicula de catalogo \n" +
                    "0. Salir");
            opciones = Integer.parseInt(scanner.nextLine());
            switch (opciones) {
                case 1:
                    System.out.println("Se inicia el catalogo.......\n");
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    System.out.println("Lista de peliculas\n");
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta luego gente.......");
                    break;
                default:
                    System.out.println("No reconozco la opcion");
            }

        }

    }
}
