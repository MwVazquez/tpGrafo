package coloreo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import grafos.GrafoNDNP;


public class Colorear {
	private int cantidadNodos;
	private GrafoNDNP grafo;
	private int gradMax;
	private int gradMin;
	/// LISTAS PARA GRABAR ARCHIVO
	private int colorMejorCasoSA;
	private NodoColor [] ordenMejorCasoSA;
	private int colorMejorCasoMa;
	private NodoColor [] ordenMejorCasoMa;
	private int colorMejorCasoWP;
	private NodoColor [] ordenMejorCasoWP;

	
	public Colorear(String path) throws IOException {
		Scanner sc = new Scanner (new FileReader(path));
		try {
			int nodos = sc.nextInt();
			grafo = new GrafoNDNP(nodos);
			int cantAristas = sc.nextInt();
			double porcentaje = sc.nextDouble();
			gradMax = sc.nextInt();
			gradMin = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < cantAristas;i++) {
				grafo.setArista(sc.nextInt(), sc.nextInt());
				sc.nextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		colorMejorCasoSA = 0;
		ordenMejorCasoSA = new NodoColor[grafo.getCantNodos()];
		
		colorMejorCasoMa = 0;
		ordenMejorCasoMa = new NodoColor[grafo.getCantNodos()];

		colorMejorCasoWP= 0;
		ordenMejorCasoWP = new NodoColor[grafo.getCantNodos()];
	}
	
	public int AlgoritmosColoreo(int algoritmo) {
		//Secuencial Aleatorio
		int [] colores = new int [cantidadNodos];
		List <NodoColor> nodos = new ArrayList<NodoColor>();
		int color = 1, colorMejorCaso;
		
		for(int i = 0; i<cantidadNodos; i++) 
			nodos.add(new NodoColor(i, grafo.getGrado(i)));
		if(algoritmo == 1)//si es welsh-powell
			Collections.sort(nodos);
		else if (algoritmo == 2)//si es matula
			Collections.sort(nodos, NodoColor.ComparadorMatula);
		else
			Collections.shuffle(nodos);//si es secuencial aleatorio

		//colorear
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
		colorMejorCaso = color-1;
		
		//Obtener mejor caso (para segunda parte)
		if(algoritmo == 0 ) {
			if(colorMejorCasoSA == 0 || colorMejorCaso <= colorMejorCasoSA) {
				colorMejorCasoSA = colorMejorCaso;
				for(int i = 0; i < cantidadNodos; i++)
					ordenMejorCasoSA[i] = nodos.get(i);
			}
		}	
		else if	(algoritmo == 1){
			if(colorMejorCasoWP == 0 || colorMejorCaso <= colorMejorCasoWP) {
				colorMejorCasoWP = colorMejorCaso;
				for(int i = 0; i < cantidadNodos; i++)
					ordenMejorCasoWP[i] = nodos.get(i);
			}
		}	
		else {
			if(colorMejorCasoMa == 0 || colorMejorCaso <= colorMejorCasoMa) {
				colorMejorCasoMa = colorMejorCaso;
				for(int i = 0; i < cantidadNodos; i++)
					ordenMejorCasoMa[i] = nodos.get(i);
			}
		}
		return colorMejorCaso;
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
