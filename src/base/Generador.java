package base;


//<<<<<<< HEAD
import java.io.IOException;
import java.util.ArrayList;
//=======
import grafos.MatrizSimetrica;
//>>>>>>> fc2cad702936f50cfd4799f31e7696bec242b0b2

public abstract class  Generador  {
	
	MatrizSimetrica matriz;
	int nodos;
	//int porcentaje;//
	int gradoMin;
	int gradoMax;
	int cantArista;
	int porcentajeAdyacencia;
	ArrayList <Arista>aristas=new ArrayList<Arista>();
	
	public Generador(int nodos, int porcentaje){
		this.nodos = nodos;
		this.porcentajeAdyacencia = porcentaje;
		this.matriz = new MatrizSimetrica(nodos);
		
	}

	public void mostrarTodaAristas() {
		
		for(int k=0; k<matriz.getTamanio(); k++)
			System.out.print(matriz.getValorIndiceVector(k) + " ");					
	}
	
	public void mostrarAristasSeteadas() {
		for(int i=0; i<matriz.getTamanio(); i++) {
			if(matriz.getValorIndiceVector(i)==1)
				System.out.print(matriz.getValorIndiceVector(i) + " ");	
		}
		System.out.println("");
	}
	
	
	public abstract void generar() throws IOException; 
}
