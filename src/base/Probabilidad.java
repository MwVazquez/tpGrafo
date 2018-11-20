package base;

import java.io.IOException;

public class Probabilidad extends Generador {

	public Probabilidad(int nodos, int porcentaje) {
		super(nodos, porcentaje);

	}

	@Override
	public void generar() throws IOException {
		Double porc = (double) this.porcentajeAdyacencia / 100;
		Double random;
		int cantArista = 0;
		int menor=0,mayor=0;
		int [] grados = new int [this.nodos]; 

		for (int i = 0; i < this.nodos - 1; i++){
	
			for (int j = i + 1; j < this.nodos; j++) {
				if ((random = Math.random()) < porc || porc.equals(random)) {
					this.matriz.ponderarArista(i, j);
					aristas.add(new Arista(i,j));
					grados[i]++;
					grados[j]++;
					cantArista++;
				}
			}
		}
		
		for (int i=0;i<grados.length;i++) {
			if(i==0 || grados[i]<menor)
				menor=grados[i];
			if(i==0 || grados[i]>mayor)
				mayor=grados[i];
		}
		///privados
		
		this.gradoMin = menor;
		this.gradoMax = mayor;
		this.cantArista=aristas.size();
		porcentajeAdyacencia= (int)((float)cantArista/(nodos*(nodos-1)/2)*100);
		
		Archivo archi=new Archivo(nodos,cantArista,porcentajeAdyacencia,gradoMin,gradoMax, aristas);
		archi.escribir();
	}


	
		
	
}
