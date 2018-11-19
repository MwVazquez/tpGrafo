package grafos;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import base.Generador;

public class GrafoNDNP extends MatrizSimetrica{
	//private int cantidadNodos;
	private int cantidadAristas;
	private double porcentajeAdy;
	private int gradoMax;
	private int gradoMin;
	public GrafoNDNP(int cantNodos, int cantidadAristas,double porcentajeAdy, int gradoMax,int gradoMin) {
		super(cantNodos);
		this.cantidadAristas  = cantidadAristas;
		this.porcentajeAdy = porcentajeAdy;
		this.gradoMax = gradoMax;
		this.gradoMin = gradoMin;
		
	}
	
	public void setArista(int f, int c){
		this.vector[getIndice(f, c)] = 1;
	}
	
	public int getCantNodos() {
		return tamanioVector;
	}
	
public static boolean programaProbador(String pathGrafo,String pathColoreado) throws IOException{
		
		GrafoNDNP grafo = Generador.leer(pathGrafo);
		
		Scanner sc = new Scanner(new File(pathColoreado));
		sc.useLocale(Locale.ENGLISH);
		
		int cantNodos = sc.nextInt();
		int cantColoresUsados = sc.nextInt();
		int cantAristas = sc.nextInt();
		double porcAdy = sc.nextDouble();
		int grMax = sc.nextInt();
		int grMin = sc.nextInt();
		
		//List<Nodo> listaColoreados = new ArrayList<Nodo>();
		int[] listaColoreados = new int [cantNodos];
		
		for(int i=0;i<cantNodos;i++) {
			listaColoreados[sc.nextInt()]=sc.nextInt();
			/*Nodo nodo = new Nodo(sc.nextInt());
		    nodo.setColor(sc.nextInt());
			listaColoreados.add(nodo);*/
		}
		
		sc.close();
		//verifico coincidencias entre el .in y el .out
		if(grafo.cantNodos!=cantNodos)
			return false;
		if(grafo.cantidadAristas!=cantAristas)
			return false;
		if(grafo.porcentajeAdy!=porcAdy)
			return false;
		if(grafo.gradoMax!=grMax)
			return false;
		if(grafo.gradoMin!=grMin)
			return false;
	
		//Se verifica que los pares de nodos adyacentes no sean del mismo color
		for(int i=0;i<=cantNodos-2;i++) 
			for (int j = i+1; j <= cantNodos-1; j++) {
				
				if(grafo.getValor(i, j) == 1)
					if(listaColoreados[i]==listaColoreados[j])
				           return false;
			}
		
		//Verifico que la cantidad de colores usados no sea mayor a la cantidad de nodos
		if(cantColoresUsados > cantNodos || cantColoresUsados <= 0)
             return false;
       //Verifico que no hayan quedado nodos sin colorear      
		for(int j=0 ;j<cantNodos;j++)
		if (listaColoreados[j] == 0) 
			return false;
		
		
		return true;
	}
}
