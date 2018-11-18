package base;

public abstract class  Generador  {
	
	MatrizSimetrica matriz;
	int nodos;
	int porcentaje;//
	int gradoMin;
	int gradoMax;
	int cantArista;
	int porcentajeAdyacencia;
	
	public Generador(int nodo, int porcentaje){
		this.nodos = nodo;
		this.porcentaje = porcentaje;
		this.matriz = new MatrizSimetrica(nodo);
	}

	public void mostrarTodaAristas() {
		
		for(int k=0; k<matriz.getTamanio(); k++)
			System.out.print(matriz.getValorIndiceVector(k) + " ");					
		System.out.println();
		System.out.println();
		System.out.println("su manera");
		for(int i=0; i<nodos; i++) {
			for (int j = i+1; j < nodos; j++) {
				System.out.print(matriz.getValorIndiceVector(i) + " ");					
			}
			//System.out.println("\n");
		}
	}
	
	public void mostrarAristasSeteadas() {
		for(int i=0; i<matriz.getTamanio(); i++) {
			if(matriz.getValorIndiceVector(i)==1)
				System.out.print(matriz.getValorIndiceVector(i) + " ");	
		}
		System.out.println("");
	}
	
	
	public abstract void generar(); 
	
}
