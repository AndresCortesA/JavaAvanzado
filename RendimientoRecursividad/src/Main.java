import java.util.stream.IntStream;

import static Recursivo.Recursividad.*;

public class Main {

    public static void main(String[] args) {
        tailRecursion(5); // cola
        System.out.println("-------------------- recursion por cabeza y cola");
        headRecusion(5); //cabeza
        System.out.println("----------------- suma");
        System.out.println("Suma funcional: " +sumaFuncional(5)); // suma funcional
        System.out.println("Suma iterativa: " +suma(5));
        System.out.println("Suma recursiva: "+sumaRecursiva(5));
        System.out.println("----------------------- factorial");
        System.out.println("factorial: " +factorial(5)); // factorial
        System.out.println("FactorialRecursivo: " + factorialRecursivo(5));
        System.out.println("FactorialFuncional: " + factorialFuncional(5)); // factorial funcional

    }
}