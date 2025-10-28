package CuentaPalabras;

public class LanzadorPalabras {
	private final static String directorioGenerarClasses= "target\\";
	private final static String rutaFicherosJava = "src\\main\\java\\CuentaPalabras\\ContadorPalabras.java";
	
	public static void main(String[] args) {
		String  ruta = "";
		LanzadorPalabras p = new LanzadorPalabras();
		p.PalabrasCompila();
		p.procesoEjecuta(ruta,"es");
		
	}
	
	public void PalabrasCompila() {
		String[] comando= {"javac", "-d", directorioGenerarClasses, rutaFicherosJava};
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
		
			Process p1 = pb.start();
			
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

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
	
}