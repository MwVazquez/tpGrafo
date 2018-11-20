package base;
import java.io.IOException;

//<<<<<<< HEAD


import java.util.ArrayList;
import java.util.Collections;


public class PorcentajeAris extends Generador{

	public PorcentajeAris(int nodos, int porcentaje) {
	
		super(nodos, porcentaje);

	}
	
	
	// prefuntar si puede venir un % menor a la cantidad de aristas minimas para que sea un grafo conexo
	// preguntar si esta bien lo del pivote
	/**
	 * hola
	 * @throws IOException 
	 */
	@Override
	public void generar() throws IOException {
		
		int cantidadAristas = (int)(((nodos*(nodos-1))/2)*(porcentajeAdyacencia/(float)100));
		//System.out.println("Can "+cantidadAristas);
		int grados[]=new int[nodos];
		int gradoMin=nodos,gradoMax=0;
		ArrayList<Arista>lista=new ArrayList<Arista>();
		for(int i=1;i<nodos;i++) {
			this.matriz.ponderarArista(0, i);
			aristas.add(new Arista(0,i));
			grados[0]++;
			grados[i]++;
			//System.out.println(0+"   "+i);
		}
		for (int i = 1; i < nodos; i++) 
			for (int j = i+1; j < nodos; j++) 
				lista.add(new Arista(i,j));
				
			
		Collections.shuffle(lista);
		Arista aux;
		
		for (int i = 0; i < cantidadAristas-nodos+1; i++) {
			aux=lista.get(i);
			this.matriz.ponderarArista(aux.nodoOrigen, aux.nodoDestino);
			aristas.add(new Arista(aux.nodoOrigen, aux.nodoDestino));
			grados[aux.nodoOrigen]++;
			grados[aux.nodoDestino]++;
			//System.out.println(aux.nodoDestino+"   "+aux.nodoOrigen);
		}
		for (int i=0;i<grados.length;i++) {
			if(i==0 || grados[i]<gradoMin)
				gradoMin=grados[i];
			if(i==0 || grados[i]>gradoMax)
				gradoMax=grados[i];
		}
		
		this.gradoMin = gradoMin;
		this.gradoMax = gradoMax;
		
		
		this.cantArista=aristas.size();
		porcentajeAdyacencia= (int)((float)cantArista/(nodos*(nodos-1)/2)*100);
		
		//System.out.println(gradoMax+"    " +"     "+porcentajeAdyacencia+" ");
		Archivo archi=new Archivo(nodos,cantArista,porcentajeAdyacencia,gradoMin,gradoMax, aristas);
		archi.escribir();
	}
	
	
}
