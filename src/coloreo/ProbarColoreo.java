package coloreo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProbarColoreo {
	
	public static void main(String[] args) throws IOException {
		int [] frecuenciaSA = new int[1000];
		int [] frecuenciaMA = new int [1000];
		int [] frecuenciaWP = new int [1000];

		Colorear color = new Colorear(".in");
		for (int i = 0; i < 10000; i++) 
			frecuenciaSA[color.AlgoritmosColoreo(0)]++;
		for (int i = 0; i < 10000; i++) 
			frecuenciaWP[color.AlgoritmosColoreo(1)]++;
		for (int i = 0; i < 10000; i++) 
			frecuenciaMA[color.AlgoritmosColoreo(2)]++;
		color.escribirArchivo();
		escribirArchivoFrecuencias("frecuenciasSA.out", frecuenciaSA);
		escribirArchivoFrecuencias("frecuenciasMA.out", frecuenciaMA);
		escribirArchivoFrecuencias("frecuenciasWP.out", frecuenciaWP);
	}

	private static void escribirArchivoFrecuencias(String path, int[] frecuencias) {
		FileWriter fw = null;
		PrintWriter pw =  null;
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			for (int i = 0; i < frecuencias.length; i++) {
				if(frecuencias[i]!= 0)
					pw.println((i+1) + " " + frecuencias[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw!= null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
	}

}
