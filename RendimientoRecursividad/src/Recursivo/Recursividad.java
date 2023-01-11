package Recursivo;

import java.util.stream.IntStream;

public class Recursividad {
    public static int suma(int numIter) {
        // 1 + 2+ 3  + 4 + 5....... 210
        int resultado = 0;
        for (int i = 0; i <= numIter; i++) {
            resultado = resultado + i;
        }

        return resultado;
    }

    public static int sumaRecursiva(int index){
        //sentencia de control
        if(index == 1){
            return 1;
        }
        return index + sumaRecursiva(index - 1);
    }
    // 5
    //  5 -> 5-1
    //     -> 4-1
    //      -> 3-1
    //       -> 2-1
    //          -> 1-1

    public static void tailRecursion(int index){
        if(index == 0){
            return;
        }
        System.out.println(index);
        tailRecursion(index - 1);
    }

    public static void headRecusion(int index){
        if(index == 0){
            return;
        }
        headRecusion(index - 1);
        System.out.println(index);
    }
    //NO necesita recursividad
    public static int sumaFuncional(int index){
        // 5 + 4 + 3 + 2 +1
//        return IntStream.rangeClosed(1, 5).sum();
        return IntStream.rangeClosed(1, index).
                reduce(0, (a, b) -> a + b);
    }

    // factorial
    public static int factorial(int index){
        int resultado = 1;
        for (int i = 1; i<= index; i++){
            resultado = resultado * i;
        }

        return resultado;
    }

    public static int factorialRecursivo(int index){
        if (index == 0){
            return 1;
        }
        return index * factorialRecursivo(index - 1);
    }

    public static int factorialFuncional(int index){
        return IntStream.rangeClosed(1, index).reduce(1, (a,b) -> a * b);
    }


}
