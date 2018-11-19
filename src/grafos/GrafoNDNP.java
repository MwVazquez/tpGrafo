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
}
