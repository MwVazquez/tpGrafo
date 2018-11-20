package base;

import java.io.IOException;

// cantidad de nodos impar, no tiene grado impar
// pares sin restricciones
//cantidad de nodos mayor a grado

public class Regular extends Generador {
	public Regular(int nodos, int grado) {
		super(nodos, 0);
		this.gradoMax = grado;
		this.gradoMin = grado;
	}

//	private int randomBetween(int a, int b) {
//		Random rnd = new Random();
//		System.out.println("a: " + a + " " + "b: " + (b));
//		return rnd.nextInt(b - a + 1) + a;
//	}

	@Override
	// lanzar una excepcion
	// en gradoMax viene el grado regular
	public void generar() throws IOException {
		if (gradoMax % 2 != 0 && nodos % 2 != 0) {
			System.out.println("cantidad de nodos impar, no tiene grado impar");
			return;
		}
		if (nodos <= gradoMax) {
			System.out.println("cantidad de nodos mayor a grado");
			return;
		}
		
		int grados[] = new int[nodos], grado = gradoMax;
		int mitad = nodos / 2;
		
		if (grado % 2 == 1) {
			for (int y = 0; y < mitad; y++) {
				this.matriz.ponderarArista(y, mitad + y);
				aristas.add(new Arista(y, mitad + y));
				grados[y]++;
				grados[mitad + y]++;
			}
			grado -= 1;
		}
		
		// circulo
		if (grado > 1) { // genero "anillos"
			int salto = 1;
			while (grado <= this.gradoMax && grado!=0) {

				for (int i = 0; i < this.nodos; i++) {
					this.matriz.ponderarArista(i, (i+salto)%nodos);
					aristas.add(new Arista(i, (i+salto)%nodos));
					grados[i]++;
					grados[(i+salto)%nodos]++;	
				}
				salto++;
				grado-=2; 
			}
		}
		
		//System.out.println("grados"+ gradoMax);
		float aux=(gradoMax/(float)(nodos-1));
		porcentajeAdyacencia= (int)(aux*100);
		this.cantArista=aristas.size();
		porcentajeAdyacencia= (int)((float)cantArista/(nodos*(nodos-1)/2)*100);
		Archivo archi=new Archivo(nodos,cantArista,porcentajeAdyacencia,gradoMin,gradoMax, aristas);
		archi.escribir();

	}

	static int obtener_mcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return obtener_mcd(b, a % b);
	}

}
