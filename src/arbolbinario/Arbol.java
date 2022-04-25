package arbolbinario;

import java.util.ArrayDeque;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(char dato) {
        raiz = new NodoArbol(dato);
    }

    public Arbol(char dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    /**
     * Recorrido en preorden
     */
    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + "  ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en orden central
     */
    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en postorden
     */
    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    /**
     * Recorrido en amplitud con una cola de nodos del árbol
     */
    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Recorrido en amplitud con una cola proporcionada por la clase ArrayDeque
     */
    public void amplitud2() {
        ArrayDeque<NodoArbol> cola = new ArrayDeque<>();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.add(raiz);
            while (!cola.isEmpty()) {
                NodoArbol nodo = cola.remove();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.add(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.add(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Ejemplo: método que recorre el árbol para determinar si contiene un dato.
     */
    public boolean contiene(int dato) {
        return this.contieneRec(raiz, dato);
    }

    private boolean contieneRec(NodoArbol nodo, int dato) {
        // Búsqueda por preorden
        boolean resul;
        if (nodo == null) {
            resul = false;
        } else if (nodo.getDato() == dato) {
            resul = true;
        } else {
            resul = this.contieneRec(nodo.getIzquierdo(), dato);
            if (!resul) {
                resul = this.contieneRec(nodo.getDerecho(), dato);
            }
        }
        return resul;
    }


    public int suma() {
        return this.sumaRec(raiz);
    }

    private int sumaRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.getDato() + this.sumaRec(nodo.getIzquierdo()) + this.sumaRec(nodo.getDerecho());
        }
    }




    public void preOrdenNivel() {
        System.out.println("Preorden con niveles: ");
        preOrdenNivelRec(raiz, 1);
    }

    private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            System.out.println(nodo.getDato() + " en el nivel " + nivel);
            preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
            preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
        }
    }

    // ------------------------------------------------------------------------
    // 2.3
    private double pasarAEntero(char c) {
        return Character.getNumericValue(c);
    }

    private boolean esOperador(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    private boolean esDigito(char c) {
        return (c >= '0' && c <= '9');
    }

    private double pasarADouble(char c) {
        double v = Character.getNumericValue(c);
        return v;
    }


    // ------------------------------------------------------------------------
    // TODO 2.3
    
   /* public Arbol(String cadena) {
        char [] aux;
        Pila pilaAuxiliar = new Pila();
        aux = cadena.toCharArray();
        for (int i = 0; i < cadena.length(); i++){
            NodoArbol numero = new NodoArbol(aux[i]);
            if (!esOperador(aux[i])){
                pilaAuxiliar.apilar(numero);         
            }else {
                char pard,pari;
                if ( i ==  cadena.length()-1){
                    pard = ' ';
                    pari = ' ';
                } else {
                    pard = '(';
                    pari = ')'; 
                }
                NodoArbol nodoDerecho = pilaAuxiliar.desapilar();
                NodoArbol parentesisDerecho = new NodoArbol(pari,nodoDerecho,null);
                NodoArbol nodoIzquierdo = pilaAuxiliar.desapilar();
                NodoArbol parentesisIzquierdo = new NodoArbol(pard,null,nodoIzquierdo);
                NodoArbol operador = new NodoArbol(aux[i], parentesisIzquierdo, parentesisDerecho);
                pilaAuxiliar.apilar(operador);
                
            }
        }
        raiz = pilaAuxiliar.desapilar();
    } */

    public Arbol(String cadena) {
        char [] aux;
        Pila pilaAuxiliar = new Pila();
        aux = cadena.toCharArray();
        for (int i = 0; i < cadena.length(); i++){
            NodoArbol numero = new NodoArbol(aux[i]);
            if (!esOperador(aux[i])){
                pilaAuxiliar.apilar(numero);         
            }else {
                NodoArbol nodoDerecho = pilaAuxiliar.desapilar();
                NodoArbol nodoIzquierdo = pilaAuxiliar.desapilar();
                NodoArbol operador = new NodoArbol(aux[i],nodoDerecho,nodoIzquierdo);
                pilaAuxiliar.apilar(operador);
            }
        }
        raiz = pilaAuxiliar.desapilar();
    } 



    // ------------------------------------------------------------------------
    // TODO 2.4

    public void MostrarExpresion() {
        System.out.print("Expresion: ");
        this.MostrarExpresionRec(raiz,1);
    }
    private void MostrarExpresionRec(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            if (nodo.getDerecho() != null  && nivel > 1) {
                System.out.print('(');
            }
            this.MostrarExpresionRec(nodo.getDerecho(),nivel+1);
            System.out.print(nodo.getDato());
            this.MostrarExpresionRec(nodo.getIzquierdo(),nivel+1);
            if (nodo.getIzquierdo() != null && nivel > 1) {
                System.out.print(')');
            }
           
        } 
    }

    // ------------------------------------------------------------------------
    // TODO 2.5

<<<<<<< HEAD
    public double calcularValor() { 

        return this.CalcularValorRec(raiz);
    }



    public double CalcularValorRec (NodoArbol nodo){
        if (nodo == null || nodo.getDato() == '(' || nodo.getDato() ==')' || nodo.getDato() == ' '){
            return 0.0;
        }else{
            if (esOperador(nodo.getDato()) ){
                if (nodo.getDato() == '+'){
                        return (this.CalcularValorRec(nodo.getDerecho()) + this.CalcularValorRec(nodo.getIzquierdo()));           
                }else if(nodo.getDato() == '-'){
                        return (this.CalcularValorRec(nodo.getDerecho()) - this.CalcularValorRec(nodo.getIzquierdo()));
                }else if(nodo.getDato() == '*'){
                        return (this.CalcularValorRec(nodo.getDerecho()) * this.CalcularValorRec(nodo.getIzquierdo()));
                }else if(nodo.getDato() == '/'){
                        return (this.CalcularValorRec(nodo.getDerecho()) / this.CalcularValorRec(nodo.getIzquierdo()));
                }
                return nodo.getDato();
            }else{
                return pasarAEntero(nodo.getDato());
            }
        }
    }
}
=======
    /**
     * Recorrido en postorden
     */
    public double calcularValor() {
        return (this.calcularValorRec(raiz));
    }

    private double calcularValorRec(NodoArbol nodo) {
        char dato;
        if (nodo == null) {
            return 0.0;
        } else {
            dato = nodo.getDato();
            if (esOperador(dato)) {
                if (dato == '+') { 
                    return (this.calcularValorRec(nodo.getDerecho()) + this.calcularValorRec(nodo.getIzquierdo()));
                }
                if (dato == '-') { 
                    return (this.calcularValorRec(nodo.getDerecho()) - this.calcularValorRec(nodo.getIzquierdo()));
                }
                if (dato == '*') { 
                    return (this.calcularValorRec(nodo.getDerecho()) * this.calcularValorRec(nodo.getIzquierdo()));
                }
                if (dato == '/') { 
                    return (this.calcularValorRec(nodo.getDerecho()) / this.calcularValorRec(nodo.getIzquierdo()));
                }
                if (dato == '(') {
                    System.out.println('(');
                    return (this.calcularValorRec(nodo.getIzquierdo()));
                }
                if (dato == ')') {
                    System.out.println(')');
                    return (this.calcularValorRec(nodo.getDerecho()));
                }

                return (dato);
            }
            else {
                    return (pasarADouble(dato));
            } 
        }
    }
}
>>>>>>> d0b46618c5d2fddd5b983746b90744f791a1689c
