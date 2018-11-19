package base;

import java.util.Random;

// cantidad de nodos impar, no tiene grado impar
// pares sin restricciones
//cantidad de nodos mayor a grado

public class Regular extends Generador {
	public Regular(int nodos, int grado) {
		super(nodos, 0);
		this.gradoMax = grado;
		this.gradoMin = grado;
	}

	private int randomBetween(int a, int b) {
		Random rnd = new Random();
		System.out.println("a: " + a + " " + "b: " + (b));
		return rnd.nextInt(b - a + 1) + a;
	}

	@Override
	// lanzar una excepcion
	// en gradoMax viene el grado regular
	public void generar() {
		if (gradoMax % 2 != 0 && nodos % 2 != 0)
			System.out.println("cantidad de nodos impar, no tiene grado impar");
		if (nodos <= gradoMax)
			System.out.println("cantidad de nodos mayor a grado");
		
		int grados[] = new int[nodos], grado = gradoMax;
		int mitad = nodos / 2;
		
		if (grado % 2 == 1) {
			for (int y = 0; y < mitad; y++) {
				this.matriz.setMatrizS(y, mitad + y);
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
					this.matriz.setMatrizS(i, (i+salto)%nodos);
					grados[i]++;
					grados[(i+salto)%nodos]++;	
				}
				salto++;
				grado-=2; 
			}
		}

//		if (grado >= 2) {
//			this.matriz.setMatrizS(0, nodos - 1);
//			grados[0]++;
//			grados[nodos - 1]++;
//			for (int y = 0; y < nodos - 1; y++) {
//				this.matriz.setMatrizS(y, y + 1);
//					grados[y]++;
//					grados[y + 1]++;
//			}
//			grado -= 2;
//		}
		

/*		while (grado > 0) {
			// cruz
			if (grado % 2 == 1) {
				for (int y = 0; y < mitad; y++) {
					this.matriz.setMatrizS(y, mitad + y);
					grados[y]++;
					grados[mitad + y]++;
				}
				grado -= 1;
			}

			// circulo
			if (grado >= 2) {
				this.matriz.setMatrizS(0, nodos - 1);
				grados[0]++;
				grados[nodos - 1]++;
				for (int y = 0; y < nodos - 1; y++) {
					this.matriz.setMatrizS(y, y + 1);
					grados[y]++;
					grados[y + 1]++;
				}
				grado -= 2;
			}
			int y = 0;
			int nodoInicialFijo = 0, nodoFinalFijo = 2, cuadrados = 0;// nodo x el cual inicio el recorrido
			int nodoInicial = nodoInicialFijo, nodoFinal = nodoFinalFijo;
			int cantidadIteraciones = nodos / 2;
			while (grado >= 2) {
				// cuadrados y demas
				int salto = nodoFinalFijo - nodoInicialFijo;
				int ciclos = nodos / salto;
				if (ciclos * salto != nodos) {
					if (ciclos % 2 == 0)
						ciclos = 2;
					else {
						ciclos = 1;
						cantidadIteraciones = nodos * 2;
					}
				}
				for (int x = 0; x < cantidadIteraciones; x++) {
					this.matriz.setMatrizS(nodoInicial, nodoFinal);
					grados[nodoInicial]++;
					grados[nodoFinal]++;
					nodoInicial = nodoFinal;
					nodoFinal += salto;
					nodoFinal = nodoFinal % nodos;
				}
				nodoFinalFijo++;
				nodoInicialFijo++;
				y++;
				/// SAlto ver....
				if (y == salto) {
					grado -= 2;
					y = 0;
					nodoInicialFijo = 0;
				}
				nodoInicial = nodoInicialFijo;
				nodoFinal = nodoFinalFijo;

			}
			System.out.println(nodoFinalFijo);
		}*/

		System.out.println("");

	}

	static int obtener_mcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return obtener_mcd(b, a % b);
	}

}
