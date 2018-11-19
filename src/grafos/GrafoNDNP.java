package grafos;

public class GrafoNDNP extends MatrizSimetrica{

	public GrafoNDNP(int nodos) {
		super(nodos);
	}
	
	public void setArista(int f, int c){
		this.vector[getIndice(f, c)] = 1;
	}
	
	public int getCantNodos() {
		return tamanio;
	}
	
	public int cantidadAristas() {
		int aristas = 0;
		int maxAristas = tamanio*(tamanio - 1)/2;
		for(int i = 0; i < maxAristas; i++)
			if(this.vector[i] == 1)
				aristas++;
		return aristas;
	}
	
	public int getMaxAristas() {
		return tamanio*(tamanio - 1)/2;
	}
}
