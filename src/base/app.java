package base;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Probabilidad GeneradorPorc = new Probabilidad(500,50);
		/*
		GeneradorPorc.generar();
		
		for(int i=0; i<GeneradorPorc.matriz.getTamanio(); i++){
//			for(int j=0; i<GeneradorPorc.nodos-1; j++){
//				if(i!=j)
//					System.out.print(GeneradorPorc.matriz.getValor(i, j) + " ");
//				
//			}
//		System.out.println();
			System.out.print(GeneradorPorc.matriz.getValorIndiceVector(i) + " ");
		}
		System.out.println("\n\ngrados");
		System.out.println(GeneradorPorc.gradoMax + "  " + GeneradorPorc.gradoMin);
	}
	
*/
		
//		PorcentajeAris nue= new PorcentajeAris(5, 0);
//		
//		nue.generar();
//		///ver como mostrar indices i y j de la matriz
//		nue.mostrarAristasSeteadas();
//		nue.mostrarTodaAristas();
//		Regular reg=new Regular(8, 8);
//		reg.generar();
//		reg.mostrarAristasSeteadas();
//		reg.mostrarTodaAristas();
		
		
//		RegularAdyacente reg=new RegularAdyacente(9, 70);
//		reg.generar();
//		reg.mostrarAristasSeteadas();
//		reg.mostrarTodaAristas();
//		
		
		NPartitos parti=new NPartitos(10, 4);
		parti.generar();
		parti.mostrarTodaAristas();
	}	
}
