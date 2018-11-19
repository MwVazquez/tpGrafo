package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import grafos.MatrizSimetrica;
import grafos.GrafoNDNP;

public abstract class  Generador  {
	
	MatrizSimetrica matriz;
	int nodos;
	int porcentaje;//
	int gradoMin;
	int gradoMax;
	int cantArista;
	int porcentajeAdyacencia;
	
	public Generador(int nodo, int porcentaje){
		this.nodos = nodo;
		this.porcentaje = porcentaje;
		this.matriz = new MatrizSimetrica(nodo);
	}

	public void mostrarTodaAristas() {
		
		for(int k=0; k<matriz.getTamanio(); k++)
			System.out.print(matriz.getValorIndiceVector(k) + " ");					
		System.out.println();
		System.out.println();
		System.out.println("su manera");
		for(int i=0; i<nodos; i++) {
			for (int j = i+1; j < nodos; j++) {
				System.out.print(matriz.getValorIndiceVector(i) + " ");					
			}
			//System.out.println("\n");
		}
	}
	
	public void mostrarAristasSeteadas() {
		for(int i=0; i<matriz.getTamanio(); i++) {
			if(matriz.getValorIndiceVector(i)==1)
				System.out.print(matriz.getValorIndiceVector(i) + " ");	
		}
		System.out.println("");
	}
	
	
	public abstract void generar(); 
	
public static GrafoNDNP leer(String path) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		
		int cantidadNodos = sc.nextInt();
		int cantidadAristas = sc.nextInt();
		double porcentajeAdy = sc.nextDouble();
		int gradoMax = sc.nextInt();
		int gradoMin = sc.nextInt();
		MatrizSimetrica matrizAdyacencia = new MatrizSimetrica(cantidadNodos);
		for(int i=0;i<cantidadAristas;i++)
			matrizAdyacencia.setMatrizS(sc.nextInt(), sc.nextInt(), 1);//(1, sc.nextInt(), sc.nextInt());
				
		 sc.close();
		return new GrafoNDNP(cantidadNodos, cantidadAristas, porcentajeAdy, gradoMax, gradoMin);
	}
   public void escribir(String nomArchivo) throws IOException{
	PrintWriter salida = new PrintWriter(new FileWriter(nomArchivo));
	
	salida.println(this.nodos+" "+this.cantArista+" "+this.porcentajeAdyacencia+" "+this.gradoMax+" "+this.gradoMin);
	
	for(int i=0;i<=nodos-2;i++) 
		for (int j = i+1; j <= nodos-1; j++)
			if(this.matriz.getValor(i, j)==1)
		     salida.println(i+" "+j);
	salida.close();
}
}
