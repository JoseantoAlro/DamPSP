package Hacienda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;



public class GeneraNSSFichero {

	
	public static void main(String[] args) throws FileNotFoundException {
		String rutaTxt = args[0];
		GeneraNSSFichero nss = new GeneraNSSFichero();
		nss.procesarArchivo(rutaTxt);

	}
	
	public void procesarArchivo(String ruta) throws FileNotFoundException {
		//recorre el archivo y filtra linea a linea
		int cont=0;
		Scanner in = null;
		PrintWriter out = null;
		File f = new File(ruta);
		File fparent = f.getParentFile();
		File fnuevo = new File(fparent,  "\\NSSs.txt"); // crea un fichero NSSs.txt a la misma
																			// altura que la ruta

		try {
			FileReader f1 = new FileReader(ruta);

			in = new Scanner(f1);
			out = new PrintWriter(fnuevo);
			while (in.hasNextLine()) {

				String linea = in.nextLine(); 
				String[] cadena = linea.split(",");			// lee una linea, 
				String p = cadena[0];
				if(p.startsWith("AN")) {					//si el pedido de la provincia coincide
				out.println(linea);							//escribe la linea
				cont++;
				}
			}
		} finally {
			if (in != null) {
				in.close();
				out.close();
			}
		}
		System.out.println("NSS tratados: "+cont);
	}
	

}
