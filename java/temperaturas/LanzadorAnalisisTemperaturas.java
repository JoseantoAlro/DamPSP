package temperaturas;

public class LanzadorAnalisisTemperaturas {
	
	private final static String directorioGenerarClasses= "target\\";
	private final static String rutaFicherosJava = "src\\main\\java\\temperaturas\\AnalizadorTemperaturas.java";
	private static String rutaTxt = "src\\main\\resources\\temperaturas.txt";

	public static void main (String[] args) {
		LanzadorAnalisisTemperaturas L = new LanzadorAnalisisTemperaturas();
		int[] umbrales = {10, 20, 25, 30, 35};

		L.compila();
		for (int i : umbrales) {
			L.ejecuta(String.valueOf(i),rutaTxt);
		}
	}
	
	
	
	
	
	
	
	public void compila() {
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
	
	public void ejecuta(String i, String j) {
		String[] comando = {"java","-cp",directorioGenerarClasses,"temperaturas.AnalizadorTemperaturas",i ,j}; 
		ProcessBuilder pb = new ProcessBuilder(comando);

				try {
					pb.redirectErrorStream(true);
					pb.inheritIO();
				
					Process p1 = pb.start();
					int exit = p1.waitFor();
					System.out.println(exit);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
}
