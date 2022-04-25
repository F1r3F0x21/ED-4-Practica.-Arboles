package arbolbinario;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("******* PRUEBAS ARBOL BINARIO DE EXPRESION **********");
        String expresion1 = "52+83-*4/";
        String expresion2 = "92+3+4*";
        String expresion3 = "29*37-5*+8/";
        String expresion4 = "9";

<<<<<<< HEAD
        Arbol ex = new Arbol(expresion1);
=======
        Arbol ex1 = new Arbol(expresion1);      
>>>>>>> d0b46618c5d2fddd5b983746b90744f791a1689c
        Arbol ex2 = new Arbol(expresion2);
        Arbol ex3 = new Arbol(expresion3);
        Arbol ex4 = new Arbol(expresion4);

<<<<<<< HEAD
        ex.MostrarExpresion();
=======
        ex1.MostrarExpresion();
        System.out.println();
        System.out.println("Resultado: " + ex1.calcularValor());
>>>>>>> d0b46618c5d2fddd5b983746b90744f791a1689c
        ex2.MostrarExpresion();
        System.out.println();
        System.out.println("Resultado: " + ex2.calcularValor());
        ex3.MostrarExpresion();
        System.out.println();
        System.out.println("Resultado: " + ex3.calcularValor());
        ex4.MostrarExpresion();
<<<<<<< HEAD

       System.out.println(ex.calcularValor());
       System.out.println(ex2.calcularValor());
       System.out.println(ex3.calcularValor());
       System.out.println(ex4.calcularValor());

=======
        System.out.println();
        System.out.println("Resultado: " + ex4.calcularValor());
>>>>>>> d0b46618c5d2fddd5b983746b90744f791a1689c
    }
}
