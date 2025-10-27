package calcularSuma;


public class LanzadorSuma {
	private final static String directorioGenerarClasses= "target\\classes";
	private final static String rutaFicherosJava = "src\\main\\java\\calcularSuma\\CalculaSuma.java";
	
	public static void main(String[]args) {
		LanzadorSuma lanzador = new LanzadorSuma();
		lanzador.procesoCompila();
		lanzador.procesoEjecuta("par","10");
		lanzador.procesoEjecuta("impar","9");
	}
	
		public void procesoCompila() {
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
		
		public void procesoEjecuta(String i, String j) {
			String[] comando = {"java","-cp", directorioGenerarClasses ,rutaFicherosJava, i, j}; 
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
