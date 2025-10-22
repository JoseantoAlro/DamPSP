package unidad1;

import java.io.IOException;

public class LanzadorJava {
	private final static String directorioGenerarClasses= "target\\";
	private final static String rutaFicherosJava = "src\\main\\java\\unidad1\\";
	
	public static void main(String[]args) {
		LanzadorJava lanzador = new LanzadorJava();
		lanzador.ejecutaProcesoCompila();
		lanzador.ejecutaproceso();
	}
		
	public void ejecutaProcesoCompila() {
		String[] comando= {"javac", "-d", directorioGenerarClasses,
				rutaFicherosJava+"Gestiona.java"};
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
		String[] comando = {"java","-cp",directorioGenerarClasses,"unidad1.Gestiona"}; 
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
	}
	
