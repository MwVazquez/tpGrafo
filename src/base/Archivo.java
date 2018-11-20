package base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Archivo {
	private int nodos ,CA, PorcentajeAd ,GrMax, GrMin;
	 ArrayList<Arista>aristas;

	public Archivo(int n, int cA, int porcentajeAd, int grMax, int grMin, ArrayList<Arista>aristas) {
		nodos = n;
		CA = cA;
		PorcentajeAd = porcentajeAd;
		GrMax = grMax;
		GrMin = grMin;
		this.aristas = aristas;
	}

	
	
//	Archivo leer (String path) throws IOException{
//		int alto,ancho;
//		Scanner sc = new Scanner(new File(path));
//		
//		int cantiMesas=sc.nextInt();
//		sc.nextLine();
//		for (int i = 0; i <cantiMesas; i++) {
//			alto=sc.nextInt();
//			ancho=sc.nextInt();
//			sc.hasNextLine();
//			depo.mesadas.add(new Mesada(alto,ancho));
//		}
//		sc.close();
//		return depo;
//	}
//	
	 void escribir() throws IOException {
		PrintWriter archivoSalida = new PrintWriter(new FileWriter("grafo" + ".in"));
		archivoSalida.println(nodos+" "+CA+" " +PorcentajeAd+" "+GrMax+" "+GrMin);
		Iterator<Arista> it = aristas.iterator();
		while(it.hasNext()){
			Arista elemento = it.next();
			archivoSalida.println(elemento.nodoOrigen+" "+elemento.nodoDestino);
		}
		archivoSalida.close();
	}


}
