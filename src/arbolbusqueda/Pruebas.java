package arbolbusqueda;

public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		System.out.println("-------------- Arbol binario de busqueda ------------");
		Alumno felipe = new Alumno("Felipe Garcia", 1253, 5.3);
		Alumno adriana = new Alumno ("Adriana Torres", 2345, 7.0);
		Alumno alicia = new Alumno ("Alicia Blazquez Martín", 5622, 10.0);
		Alumno diego = new Alumno ("Diego Perez Gonzalez", 8135 ,8.0);
		Alumno mar = new Alumno ("Mar Hernando Lopez", 8217, 6.3);
		Alumno pedro = new Alumno ("Pedro Jimenez del Pozo", 8510, 3.0); 
		Alumno eduardo = new Alumno ("Eduardo Parra Martín", 8765, 6.7);
		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
		arbol.insertar(alicia);
		arbol.insertar(pedro);
		arbol.insertar(adriana);
		arbol.insertar(felipe);
		arbol.insertar(eduardo);
		arbol.insertar(diego);
		arbol.insertar(mar);
<<<<<<< HEAD
		arbol.aLista().mostrar();
=======

		arbol.aLista().mostrar();
		
>>>>>>> 498a1afafd1f7ae8b07fc12c6fdc9387992a702f
	}
}
