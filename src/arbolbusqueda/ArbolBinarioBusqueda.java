package arbolbusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;
	private int numElementos;

	public ArbolBinarioBusqueda() {
		raiz = null;
		numElementos = 0;
	}

	public boolean vacia() {
		return raiz == null;
	}


	/**
	 * Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
	 * y si no la encuentra devuelve NULL.
	 */
	public Alumno getElemento(int clave) {
		return this.getElementoRec(raiz, clave);
	}

	private Alumno getElementoRec(NodoArbol nodo, int clave) {
		if (nodo == null) {    // No encontrado
			return null;
		} else if (clave == nodo.getClave()) {    // Encontrado
			return nodo.getDato();
		} else if (clave < nodo.getClave()) {     // Subárbol izquierdo
			return this.getElementoRec(nodo.getIzquierdo(), clave);
		} else {        // Subárbol izquierdo
			return this.getElementoRec(nodo.getDerecho(), clave);
		}
	}

	/**
	 * Inserta el alumno en la posición que le corresponde según la clave
	 */
	public boolean insertar(Alumno dato) {
		int previousNumElementos = numElementos;
		raiz = this.insertarRec(raiz, dato);
		return (previousNumElementos < numElementos);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato) {
		if (nodo == null) {
			nodo = new NodoArbol(dato);   // Crear nuevo nodo
			numElementos++;
		} else if (dato.getMatricula() < nodo.getClave()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getClave()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {
			System.out.println("Error inserción. La clave " + dato.getMatricula() + " ya existe");
			nodo = null;
		}
		return nodo;
	}


	/**
	 * Determina si la clave recibida como parámetro existe en la lista.
	 */
	public boolean contiene(int clave) {
		return this.getElemento(clave) != null;
	}

	/**
	 * Elimina de la lista el alumno con número de matrícula clave,
	 * en caso de existir.
	 */
	public boolean borrar(int clave) {
		int previousNumElementos = numElementos;
		raiz = this.borrarRec(raiz, clave);
		return (numElementos < previousNumElementos);
	}

	private NodoArbol borrarRec(NodoArbol nodo, int clave) {
		if (nodo == null) {
			System.out.println("la clave buscada no existe");
		} else if (nodo.getClave() > clave) {  // Buscar en subarbol izquierdo
			NodoArbol nuevoIzq = this.borrarRec(nodo.getIzquierdo(), clave);
			nodo.setIzquierdo(nuevoIzq);
		} else if (nodo.getClave() < clave) {  // Buscar en subarbol derecho
			NodoArbol nuevoDer = this.borrarRec(nodo.getDerecho(), clave);
			nodo.setDerecho(nuevoDer);
		} else {  // Borrar elemento en nodo
			if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
				nodo = null;  // Caso 1
			} else if (nodo.getDerecho() == null) {  // Caso 2
				nodo = nodo.getIzquierdo();
			} else if (nodo.getIzquierdo() == null) {  // Caso 2
				nodo = nodo.getDerecho();
			} else {    // Caso 3
				NodoArbol nuevoIzq = this.cambiarPorMenor(nodo, nodo.getIzquierdo());
				nodo.setIzquierdo(nuevoIzq);
			}
			numElementos--;
		}
		return nodo;
	}

	private NodoArbol cambiarPorMenor(NodoArbol nodoBorrar, NodoArbol nodoMenor) {
		if (nodoMenor.getDerecho() != null) {   // Seguir en subárbol derecho
			NodoArbol nuevoDer = this.cambiarPorMenor(nodoBorrar, nodoMenor.getDerecho());
			nodoMenor.setDerecho(nuevoDer);
			return nodoMenor;
		} else {  // Encontrado nodo menor inmediato
			nodoBorrar.setDato(nodoMenor.getDato()); // Cambiar datos de nodos
			return nodoMenor.getIzquierdo();  // Devolver subarbol izquierdo de menor inmediato
		}
	}

	public int getNumElementos() {
		return numElementos;
	}

	public void preOrdenNivel() {
		System.out.println("Preorden con niveles: ");
		preOrdenNivelRec(raiz, 1);
	}

	private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
		if (nodo != null) {
			System.out.println("Clave " + nodo.getClave() + ". En el nivel " + nivel);
			preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
			preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
		}
	}

	// ------------------------------------------------------------------------
	// TODO 3.2
	
	public ListaOrdinalAlumnos aLista() {
		ListaOrdinalAlumnos lista = new ListaOrdinalAlumnos();
		return(aListaRec(raiz,raiz.getClave(),lista));
	}

	public ListaOrdinalAlumnos aListaRec(NodoArbol nodo, int min, ListaOrdinalAlumnos orden){
		if (nodo!=null) {
			if (nodo.getIzquierdo()!= null) {
					aListaRec(nodo.getIzquierdo(),nodo.getClave(),orden);
					orden.insertar(nodo.getDato());	
					aListaRec(nodo.getDerecho(),nodo.getClave(),orden);
			} else {
				orden.insertar(nodo.getDato());	
				aListaRec(nodo.getDerecho(),nodo.getClave(),orden);
				aListaRec(nodo.getIzquierdo(),nodo.getClave(),orden);	
			}
		}
		return orden;
	}



	// ------------------------------------------------------------------------
	// TODO 3.3
	public Alumno getCalificacionMaxima(int minimaMat, int maximaMat) {
		if  (getCalificacionAlumnoRec(minimaMat,maximaMat,raiz) == null){
			return null;
		}else{
			return getCalificacionAlumnoRec(minimaMat,maximaMat,raiz);
		}
		
	}
	private Alumno getCalificacionAlumnoRec(int minimaMat, int maximaMat,NodoArbol nodo){
		Alumno alumno = null;
		int matricula = 0;
		double cal = 0.0;
		if(nodo != null){
			this.getCalificacionAlumnoRec(minimaMat,maximaMat,nodo.getIzquierdo());
			matricula = nodo.getDato().getMatricula();
			if(matricula>= minimaMat && matricula <= maximaMat){
				if(cal < nodo.getDato().getCalificacion()){
					cal = nodo.getDato().getCalificacion();
					alumno = nodo.getDato();
				}
			}
			this.getCalificacionAlumnoRec(minimaMat,maximaMat,nodo.getDerecho());

		}
		return alumno;
	}


	// ------------------------------------------------------------------------
	// TODO 3.4
	public double getCalificacionMedia(int minimaMat, int maximaMat) {

		double CalMedia =  recgetCalificacionMedia(minimaMat, maximaMat, raiz);
		if(CalMedia == 0.0){
			return CalMedia;
		}
		int NumAl = numAlumnos(minimaMat,maximaMat);
		return CalMedia/NumAl;
	}
	public double recgetCalificacionMedia(int minimaMat,int maximaMat, NodoArbol nodo){
		double num = 0.0;
		int matricula = 0;
		if(nodo != null){
			double izquierdo = this.recgetCalificacionMedia(minimaMat,maximaMat,nodo.getIzquierdo());
			matricula = nodo.getDato().getMatricula();
			if(matricula>= minimaMat && matricula <= maximaMat){
				num = num + nodo.getDato().getCalificacion();
			}
			double derecho = this.recgetCalificacionMedia(minimaMat,maximaMat,nodo.getDerecho());
			num = num + izquierdo + derecho;
		}
		if(num == 0){
			return 0.0;
		}
		return num;
	}

	public int numAlumnos(int minimaMat, int maximaMat){
		return recNumAlumnos(minimaMat,maximaMat,raiz);
	}

	public int recNumAlumnos(int minimaMat, int maximaMat, NodoArbol nodo){
		int num = 0;
		int matricula = 0;
		if(nodo != null){
			int izquierdo = this.recNumAlumnos(minimaMat,maximaMat,nodo.getIzquierdo());
			matricula = nodo.getDato().getMatricula();
			if(matricula>= minimaMat && matricula <= maximaMat){
				num++;
			}
			int derecho = this.recNumAlumnos(minimaMat,maximaMat,nodo.getDerecho());
			num = num + izquierdo + derecho;
		}
		return num;
	}

	// ------------------------------------------------------------------------
	// TODO 3.5
	public boolean esEquilibrado() {
		return this.recesEquilibrado(raiz);
	}

	private boolean recesEquilibrado(NodoArbol nodo) {
		boolean resultado = false;
		if (nodo == null) {
			resultado = true;
		} else {
			if (RecAltura(nodo.getDerecho()) - RecAltura(nodo.getIzquierdo()) == 1 || RecAltura(nodo.getDerecho()) - RecAltura(nodo.getIzquierdo()) == -1 || RecAltura(nodo.getDerecho()) - RecAltura(nodo.getIzquierdo()) == 0){
				resultado = true;
			}
			else{
				resultado = false;
			}
			resultado = resultado && recesEquilibrado(nodo.getIzquierdo()) && recesEquilibrado(nodo.getDerecho());
		}
		return resultado;
	}

	
	private int altura(){
		return this.RecAltura(raiz);
	}
	
	private int RecAltura(NodoArbol nodo){
		int resultado;
		if(nodo == null){
			resultado = 0;
		}
		else{
			int Iz = this.RecAltura(nodo.getIzquierdo());
			int Der = this.RecAltura(nodo.getDerecho());
			if(Der > Iz){
				resultado = Der + 1;
			}
			else{
				resultado = Iz + 1;
			}

		}

		return resultado;
	}



}
