package unidad1;
													//lectura de consola que escribe el syso de hijo
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Padre {

	private final static String directorioGenerarClasses = "target\\";
	private final static String rutaFicherosJava = "src\\main\\java\\unidad1\\";



	public void ejecutaProcesoCompila() {
		String[] comando = { "javac", "-d", directorioGenerarClasses, rutaFicherosJava + "Hija.java" };
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

	public void ejecutaproceso() {
		String[] comando = { "java", "-cp", directorioGenerarClasses, "unidad1.Hija" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		//importante lectura de hijos
		
		
		try {
			//pb.redirectErrorStream(true);
			//pb.inheritIO();  //comentado por que si no el error lo da el hijo pero el padre no se entera

			Process p1 = pb.start();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

			int exit = p1.waitFor();
			System.out.println(exit);

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
					linea = reader.readLine();
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		Padre p = new Padre();
		p.ejecutaProcesoCompila();
		p.ejecutaproceso();
		
	}
}
