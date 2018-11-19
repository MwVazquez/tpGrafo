package coloreo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import base.MatrizSimetrica;


public class Colorear {
	private int cantidadNodos;
	private MatrizSimetrica grafo;

	
	public static void main(String[] args) {
		//leo el archivo y seteo la matriz
		
	}
	
	public void AlgoritmosColoreo(int algoritmo) {
		//Secuencial Aleatorio
		int [] colores = new int [cantidadNodos];
		List <NodoColor> nodos = new ArrayList<NodoColor>();
		int color = 1;
		for(int i = 0; i<cantidadNodos; i++) 
			nodos.add(new NodoColor(i, grafo.getGrado(i)));
		//colorear
		Collections.shuffle(nodos);
		if(algoritmo == 1)//si es welsh-powell
			Collections.sort(nodos, )
		for(int i = 0; i < cantidadNodos; i++) {
			int contadorColores = 1;//cuando encuentro un nodo que puedo pintar del mismo color lo incremento
			int nodoI = nodos.get(i).getNodo();
			int colorI = nodos.get(i).getColor();
			if(colorI == 0) {
				nodos.get(i).setColor(color);
				colores[0] = nodoI;
				for(int j = i + 1; j < cantidadNodos;j++) {
					int nodoJ = nodos.get(j).getNodo();
					int colorJ = nodos.get(j).getColor();
					if(nodoI != nodoJ && !esAdyacente(colores, contadorColores, nodoJ) && colorJ == 0) {
						nodos.get(j).setColor(color);
						colores[contadorColores] = nodoJ;
						contadorColores++;
					}
				}
				color++;
			}
		}
	}
	
	private boolean esAdyacente(int[] colores, int limite, int nodoJ) {
		boolean res = false;
		int nodoVisto = 0;
		while(nodoVisto < limite) {
			if (grafo.getValor(nodoJ, colores[nodoVisto])==1)
				res = true;
			nodoVisto++;
		}
		return res;
	}
	
}
