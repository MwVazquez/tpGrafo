package base;

import java.io.IOException;

public class app {

	public static void main(String[] args) throws IOException {
		
		Probabilidad GeneradorPorc = new Probabilidad(500,50);
		GeneradorPorc.generar();
		
		
		PorcentajeAris nue= new PorcentajeAris(5, 0);
		
		nue.generar();
		///ver como mostrar indices i y j de la matriz
//		nue.mostrarAristasSeteadas();
//		nue.mostrarTodaAristas();
		
		Regular reg=new Regular(8, 7);
		reg.generar();
//		reg.mostrarAristasSeteadas();
//		reg.mostrarTodaAristas();
		
		
		RegularAdyacente reg2=new RegularAdyacente(9, 70);
		reg2.generar();
//		reg2.mostrarAristasSeteadas();
//		reg2.mostrarTodaAristas();
		
		
		NPartitos parti=new NPartitos(10, 4);
		parti.generar();
//		parti.mostrarTodaAristas();
		
		PorcentajeAris por=new PorcentajeAris(6, 90);
		por.generar();
	}	
}
