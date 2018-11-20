package base;

import java.io.IOException;

public class RegularAdyacente extends Generador {

	
	public RegularAdyacente(int nodos, int porcentajeAdyacencia) {
		super(nodos, porcentajeAdyacencia);
	}
	
	@Override
	public void generar() throws IOException {
		float grado=((float)porcentajeAdyacencia/100)*(float)(nodos-1);
		float aux=grado-(int)grado;
		if(aux>0.5)
			grado++;
		Regular reg=new Regular(nodos,(int)grado);
		//System.out.println((int)grado);
		reg.generar();
		matriz=reg.matriz;
		cantArista=reg.cantArista;
		porcentajeAdyacencia=reg.porcentajeAdyacencia;
		gradoMax=reg.gradoMax;
		gradoMin=reg.gradoMin;
		
		Archivo archi=new Archivo(nodos,cantArista,porcentajeAdyacencia,gradoMin,gradoMax, aristas);
		archi.escribir();
	}
}
