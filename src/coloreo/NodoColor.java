package coloreo;

public class NodoColor implements Comparable <NodoColor>{

	private int grado;
	private int nodo;
	private int color;
	
	public NodoColor(int nodo, int grado) {
		this.grado = grado;
		this.nodo = nodo;
		this.color = 0;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public int compareTo(NodoColor arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
