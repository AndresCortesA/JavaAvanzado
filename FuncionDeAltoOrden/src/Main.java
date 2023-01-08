import Funcionales.Funcionales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Funcionales f = new Funcionales();
//        f.pruebas();
        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Paquita");
        nombres.add("Tolomea");
        nombres.add("Mircelfa");

        Stream<String> valores = nombres.stream()
                        .map(x -> x.toUpperCase())
                        .filter(x->x.startsWith("P"));
        valores.forEach(x-> System.out.println(x));

        System.out.println("arreglo funcional");
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        var stNumero  = Arrays.stream(numeros);
        var resultado = stNumero.filter(x->x%2==0).reduce(0, (x,y)->{
            System.out.println("X: " + x +" Y: " + y);
            return x+y;

        });

        System.out.println("Mi suma es: " + resultado);

    }

}