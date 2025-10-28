package unidad1;  //lee argumentos

public class Leoargumentos {
	private final static String directorioGenerarClasses= "target\\";
	private final static String rutaFicherosJava = "src\\main\\java\\unidad1\\";
	public static void main(String[]args) {
		Leoargumentos lanzador = new Leoargumentos();
		lanzador.ejecutaProcesoCompilaPadre();
		lanzador.ejecutaproceso();
	}
	
	
	public void ejecutaProcesoCompilaPadre() {
		String[] comando= {"javac", "-d", directorioGenerarClasses,
				rutaFicherosJava+"procesoHijo.java"};
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
		String[] comando = {"java","-cp",directorioGenerarClasses,"unidad1.procesoHijo", "hola", "adios"}; 
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
