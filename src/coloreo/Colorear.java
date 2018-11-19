package coloreo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	double porcentaje;
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
			porcentaje = sc.nextDouble();
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
		sc.close();
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
		colorMejorCaso = color-1;// por si es uno, para que entre por cero
		
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
	
	public void escribirArchivo() {
		grabar("secuencialAleatorio.out", colorMejorCasoSA, ordenMejorCasoSA);
		grabar("Matula.out", colorMejorCasoMa, ordenMejorCasoMa);
		grabar("Welsh-Powell.out", colorMejorCasoWP, ordenMejorCasoWP);
	}
	
	public void grabar(String path, int colorMejor, NodoColor[] ordenMejor){
	     FileWriter fichero = null;
	     PrintWriter pw = null;
			try {
			fichero = new FileWriter(path);
			pw = new PrintWriter(fichero);
			int cantNod = grafo.getCantNodos();
			int cantAristas = grafo.cantidadAristas();
			double porcentaje = (double) grafo.cantidadAristas() * 100 / grafo.getMaxAristas();
			pw.println(cantNod + " " + colorMejor + " " + cantAristas + " " + porcentaje + " " + gradMax + " " + gradMin);
			for(NodoColor nodo: ordenMejor)
				pw.println("nodo " + (nodo.getNodo() + 1) + " color " + nodo.getColor());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if (fichero != null)
					fichero.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		}
	}

	
}
