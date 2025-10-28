package CuentaPalabras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ContadorPalabras {
	
	private final static String rutaRes = "src/main/resources/fichero.txt";
	
	public static void main(String[]args) {
		ContadorPalabras p =new ContadorPalabras();
		String ruta = rutaRes+args[0];
		String palabra = args[1];
		
		
		try {
			System.out.println("hay "+p.contar(ruta, palabra)+" "+ palabra+" en el texto");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int contar(String ruta, String palabra) throws FileNotFoundException  {
		int cont=0;
		Scanner in=null;
		try {
			FileReader f = new FileReader(ruta);
			in = new Scanner(f);
			while(in.hasNext()) {
				String palabraFich = in.next();
				if(palabraFich.equalsIgnoreCase(palabra)) {
					cont++;
				}
			}
		}finally{
			if (in != null) {
				in.close();
			}
			
		} 
		return cont;
	}
	
	public void escribir(String ruta,String mensaje)  throws FileNotFoundException  {
		PrintWriter out = null;
		
		try {
			FileWriter f = new FileWriter(ruta);
			out = new PrintWriter(f);
			out.printf(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally		{
			if (out!=null)
				out.close();
		}
	}

}
