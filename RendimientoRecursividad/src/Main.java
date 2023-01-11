import java.util.stream.IntStream;

import static Recursivo.Recursividad.*;

public class Main {

    public static void main(String[] args) {
        tailRecursion(5); // cola
        System.out.println("--------------------");
        headRecusion(5); //cabeza
        System.out.println("-----------------");
        System.out.println("Suma funcional: " +sumaFuncional(5)); // suma funcional
        System.out.println("Suma iterativa: " +suma(5));
        System.out.println("Suma recursiva: "+sumaRecursiva(5));

    }
}