package base;

public class RegularAdyacente extends Generador {

	
	public RegularAdyacente(int nodos, int porcentajeAdyacencia) {
		super(nodos, porcentajeAdyacencia);
	}
	
	@Override
	public void generar() {
		float grado=((float)porcentaje/100)*(float)(nodos-1);
		float aux=grado-(int)grado;
		if(aux>0.5)
			grado++;
		Regular reg=new Regular(nodos,(int)grado);
		System.out.println((int)grado);
		reg.generar();
		matriz=reg.matriz;
	}
}
