package base;

import java.io.IOException;
import java.util.Vector;

public class NPartitos extends Generador {

	private int cantidadGrupos;
	public NPartitos(int nodo, int cantidadGrupos) {
		super(nodo, 0);
		this.cantidadGrupos=cantidadGrupos;
	}

	@Override
	public void generar() throws IOException {
		double cantAristas = 0;
		int grados[]=new int[nodos];
		int gradoMin=nodos,gradoMax=0;
		if(cantidadGrupos<=1) {
			System.out.println("no hago nada");
			return;
		}
		if(cantidadGrupos>nodos) {
			System.out.println("No se puede realizar");
			return;
		}	
		Vector <Integer> grupos = new Vector<Integer>();

		for(Integer i=0; i<nodos; i++) 
			grupos.add(i%cantidadGrupos);
		
		for (int i = 0; i < nodos-1; i++) {
			for (int j = i+1; j < nodos ; j++) {
				if(grupos.get(i) != grupos.get(j)) {
					this.matriz.ponderarArista(i, j);
					aristas.add(new Arista(i,j));
					grados[i]++;
					grados[j]++;
					cantAristas++;
				}
			}	
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
		porcentajeAdyacencia= (int)((float)cantAristas/(nodos*(nodos-1)/2)*100);
		this.cantArista=(int)cantAristas;			
		
//		System.out.println("gradoMin: " + gradoMin + "\n" +
//							"gradoMax: " + gradoMax + "\n" +
//							"Adyacencia: "+ porcentajeAdyacencia + "\n" + 
//							"cantAristas: " + cantAristas + "\n" +
//							"nodos: " + nodos);
//		System.out.println();
//		 
		Archivo archi=new Archivo(nodos,cantArista,porcentajeAdyacencia,gradoMin,gradoMax, aristas);
		archi.escribir();
	}
}