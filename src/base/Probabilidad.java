package base;

public class Probabilidad extends Generador {

	public Probabilidad(int nodos, int porcentaje) {
		super(nodos, porcentaje);

	}

	@Override
	public void generar() {
		Double porc = (double) this.porcentaje / 100;
		Double random;
		int cantArista = 0;
		int menor=0,mayor=0;
		int [] grados = new int [this.nodos]; 

		for (int i = 0; i < this.nodos - 1; i++){
	
			for (int j = i + 1; j < this.nodos; j++) {
				if ((random = Math.random()) < porc || porc.equals(random)) {
					this.matriz.setMatrizS(i, j);
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
		this.cantArista = cantArista;
		this.gradoMin = menor;
		this.gradoMax = mayor;
		this.porcentajeAdyacencia = cantArista/(this.nodos*(this.nodos-1)/2);
	}


	
		
	
}
