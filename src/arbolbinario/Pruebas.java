package arbolbinario;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("******* PRUEBAS ARBOL BINARIO DE EXPRESION **********");
        String expresion1 = "52+83-*4/";
        String expresion2 = "92+3+4*";
        String expresion3 = "29*37-5*+8/";
        String expresion4 = "9";

        Arbol ex1 = new Arbol(expresion1);
        Arbol ex2 = new Arbol(expresion2);
        Arbol ex3 = new Arbol(expresion3);
        Arbol ex4 = new Arbol(expresion4);

        ex1.MostrarExpresion();
        System.out.println();
        System.out.println("Resultado: " + ex1.calcularValor());
        System.out.println();

        ex2.MostrarExpresion();
        System.out.println();
        System.out.println("Resultado: " + ex2.calcularValor());
        System.out.println();

        ex3.MostrarExpresion();
        System.out.println();
        System.out.println("Resultado: " + ex3.calcularValor());
        System.out.println();

        ex4.MostrarExpresion();
        System.out.println();
        System.out.println("Resultado: " + ex4.calcularValor());
        System.out.println();
    }
}
