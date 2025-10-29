package Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LanzadorProvincias {
	private final static String directorioGenerarClasses= "target\\";
	private final static String rutaFicherosJava = "src\\main\\java\\Amazon\\SepararProvincias.java";
	
	
	public static void main(String[]args) {
		LanzadorProvincias l = new LanzadorProvincias();
		String[] provincias = {"Huelva", "Sevilla", "Cádiz", "Málaga", "Córdoba", "Granada", "Jaén", "Almería" };
		int total= 0;
		l.compilaprov();
		for (String p:provincias) {				//por cada provincia ejecuta el proceso, devuleve un int y lo va sumando al total 
			total=total+l.ejecutaprov(p);
			
		}
		System.out.println("Total de pedidos: "+total);
	}
	
	
	public void compilaprov() {										//compila 
		String[] comando= {"javac", "-d", directorioGenerarClasses,
				rutaFicherosJava};
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
	
	public int ejecutaprov(String i) {			//ejecuta pidiendo la provincia y devuelve la suma del pedido que lee de consola
		
		int salida=0;
		String[] comando = {"java","-cp",directorioGenerarClasses,"Amazon.SepararProvincias",i }; 
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
							salida = Integer.parseInt(salidas[1].replaceAll("^\\s+", ""));
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

