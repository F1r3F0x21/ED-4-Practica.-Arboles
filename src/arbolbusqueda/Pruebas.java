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

		arbol.aLista().mostrar();

		System.out.println(); 
		System.out.println("La calificacion Maxima de los alumnos entre el rango 500 y 8500 es: ");           
		arbol.getCalificacionMaxima(500, 8500).mostrar();
		System.out.println("La calificacion media de los alumnos entre el rango 500 y 8500 es: "+ arbol.getCalificacionMedia(500,8500));
		System.out.println(); 

		if (arbol.getCalificacionMaxima(500, 1000) == null){
			System.out.println("La calificacion Maxima de los alumnos entre el rango 500 y 1000 es: null"); 
		}else{
			System.out.println("La calificacion Maxima de los alumnos entre el rango 500 y 1000 es: "); 
			arbol.getCalificacionMaxima(500, 1000).mostrar();
		}
		
		System.out.println("La calificacion media de los alumnos entre el rango 500 y 8500 es: "+ arbol.getCalificacionMedia(500,1000));
		System.out.println(); 
		System.out.println("¿Es este arbol equilibrado?: "+arbol.esEquilibrado());
		arbol.borrar(felipe.getMatricula());
		System.out.println("Se ha borrado un alumno con matricula "+felipe.getMatricula()+ " La nueva lista de alumnos es: ");
		arbol.aLista().mostrar();
		System.out.println(); 
		System.out.println("¿Es este arbol equilibrado, despues de borrar a Felipe?: "+ arbol.esEquilibrado());
		}
}
