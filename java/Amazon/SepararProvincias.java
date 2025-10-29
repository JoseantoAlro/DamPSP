package Amazon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class SepararProvincias {
	private static String rutaTxt = "src\\main\\resources\\pedidos.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		String provincia = args[0];
		SepararProvincias s = new SepararProvincias();
		s.procesarArchivo(rutaTxt, provincia);

	}
	
	public void procesarArchivo(String ruta, String provincia) throws FileNotFoundException {
		//recorre el archivo y filtra linea a linea
		int cont=0;
		Scanner in = null;
		PrintWriter out = null;
		File f = new File(ruta);
		File fparent = f.getParentFile();
		File fnuevo = new File(fparent,  "\\provincias\\"+ provincia + ".txt"); // crea un fichero "provincia".txt a la misma
																			// altura que la ruta

		try {
			FileReader f1 = new FileReader(ruta);

			in = new Scanner(f1);
			out = new PrintWriter(fnuevo);
			in.nextLine();						//salta la primera linea(encabezado)
			while (in.hasNextLine()) {

				String linea = in.nextLine(); 				// lee una linea, 
				String p = procesarpedido(linea);			//la pasa a pedido
				if(p.equals(provincia)) {					//si el pedido de la provincia coincide
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
		System.out.println("Pedidos en "+provincia+" : "+cont);
	}
	
	
	
	public String procesarpedido(String linea) { //coge la linea y la convierte a pedido
		String[] cadena = linea.split("#");
		String p = cadena[5].replaceAll("\\s+$", "");
		/*
		Pedido p = new Pedido(
				cadena[0]									//nombre
				,Integer.parseInt(cadena[1].substring(1))	//numuni
				,Integer.parseInt(cadena[2].substring(1))	//importe
				,Integer.parseInt(cadena[3].substring(1))	//numref
				,cadena[4] 									//direccion
				,cadena[5]									//provincia
				,cadena[6]);								//fecha
				
		*/
		return p;
	}
}
