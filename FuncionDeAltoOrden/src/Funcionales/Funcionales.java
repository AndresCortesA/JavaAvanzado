package Funcionales;

import java.util.function.Function;

public class Funcionales {
    //Funcion de alto nivel
    private Function<String,String> toMayus = x -> x.toUpperCase();
    private Function<Integer, Integer> sumador= x -> x.sum(x,x);

    //Metodos

    public void pruebas(){
        System.out.println(toMayus.apply("Victor"));
        System.out.println(sumador.apply(5));

        System.out.println("------saluda");
        saluda(toMayus, "Victor");
    }
//    public static String  toMayus(String nombre){
//        return nombre.toUpperCase();
//    }

    public void saluda(Function<String,String> miFuncion, String nombre){
        miFuncion.apply(nombre);
    }

}
