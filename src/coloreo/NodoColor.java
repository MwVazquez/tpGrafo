package coloreo;

import java.util.Comparator;

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
	public int compareTo(NodoColor o) {
		return this.grado > o.grado? 1: this.grado == o.grado? 0 : -1;
	}
	
	public static Comparator<NodoColor> ComparadorMatula = new Comparator<NodoColor>() {
		public int compare(NodoColor g1, NodoColor g2) {
			return g1.grado > g2.grado? -1: g1.grado == g2.grado? 0 : 1;
		}
	};
}
