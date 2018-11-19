package base;

public class MatrizSimetrica {

	private int vector[];
	private int nodos;
	private int tamanio;
	
	public MatrizSimetrica(int nodos) {
		this.nodos = nodos;
		this.tamanio = ( (int)Math.pow(nodos, 2) - nodos ) / 2;;
		this.vector= new int[tamanio];
	}
	
	public void setMatrizS(int f, int c) {
		this.vector[getIndice(f, c)] = 1;
	}
	
	public void setMatrizS(int f, int c, int costo) {
		this.vector[getIndice(f, c)] = costo;
	}

	public int getValor(int f, int c) {
		return this.vector[getIndice(f, c)];
	}
	
	public boolean getEnlace(int f, int c) {
		return this.vector[getIndice(f, c)]!=0;
	}
	
	
	public int getIndice(int f, int c) {
		
		int aux;
		if(f > c) {
			aux = f;
			f=c;
			c=aux;
		}
		
		return f*this.nodos + c - ( (int)Math.pow(f, 2)+ 3*f +2 )/2;
	}
	
	
	public int getTamanio() {
		return this.tamanio;
	}
	
	public int getValorIndiceVector(int i) {
		return this.vector[i];
	}
	
	public int getNodos() {
		return this.nodos;
	}
	
	public int getGrado(int nodo) {
		int grado = 0;
		for(int i = 0; i < tamanio; i++)
			if(vector[getIndice(nodo, i)] == 1)
				grado++;
		return grado;
	}
}