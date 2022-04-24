package arbolbinario;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS ARBOL BINARIO DE EXPRESION **********");
        String expresion1 = "52+83-*4/";
        String expresion2 = "92+3+4*";
        String expresion3 = "29*37-5*+8/";
        String expresion4 = "9";
        Arbol ex = new Arbol(expresion1);
        Arbol ex2 = new Arbol(expresion2);
        Arbol ex3 = new Arbol(expresion3);
        Arbol ex4 = new Arbol(expresion4);
        ex.MostrarExpresion();
        ex2.MostrarExpresion();
        ex3.MostrarExpresion();
        ex4.MostrarExpresion();
       System.out.println(ex.calcularValor());
    }
}
