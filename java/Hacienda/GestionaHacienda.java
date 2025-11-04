package Hacienda;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GestionaHacienda {
	private final static String directorioGenerarClasses= "target\\";
	private final static String rutaFicherosJava = "src\\main\\java\\Hacienda\\";
	
	private final static String rutaResources = "src\\main\\resources\\datos.txt";
	private final static String ejecNSS = "Hacienda.GeneraNSSFichero";
	private final static String ejecDNI = "Hacienda.GeneraDNIFichero";
	
	public static void main(String[]args) {
		GestionaHacienda gh = new GestionaHacienda();
		int total = 0;
		gh.compilahac("GeneraNSSFichero.java");
		gh.compilahac("GeneraDNIFichero.java");
		total = total + gh.ejecutahac(rutaResources, ejecNSS);
		total = total + gh.ejecutahac(rutaResources, ejecDNI);
		
		System.out.print("Número total de contribuyentes tratados: "+total);
				
	}
	
	public void compilahac(String fichero) {										//compila 
		String[] comando= {"javac", "-d", directorioGenerarClasses,
				rutaFicherosJava+fichero};
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
		
			Process p1 = pb.start();
			int exit = p1.waitFor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int ejecutahac(String i, String clss) {			//ejecuta pidiendo la ruta y devuelve la suma del usuarios que lee de consola
		
		int salida=0;
		String[] comando = {"java","-cp",directorioGenerarClasses,clss,i }; 
		ProcessBuilder pb = new ProcessBuilder(comando);

				try {
					//pb.redirectErrorStream(true);
					//pb.inheritIO();
				
					Process p1 = pb.start();
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));		//lee del hijo
					BufferedReader errorReader = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

					
					int exit = p1.waitFor();
					if (exit != 0) {
						String errorLinea = errorReader.readLine();
						while (errorLinea != null) {
							System.err.println("Error Padre: " + errorLinea);
							errorLinea = errorReader.readLine();
						}
					} else {
						String linea = reader.readLine();	

						while (linea != null) {
							System.out.println("Padre: " + linea);
							String[] salidas = linea.split(":");
							salida = Integer.parseInt(salidas[1].replaceAll("^\\s+", ""));  //.replaceAll("^\\s+|\\s+$", ""); los quita al final
							linea = reader.readLine();
						}

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return salida;
		}
}
