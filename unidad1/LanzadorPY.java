package unidad1;

public class LanzadorPY {
	private final static String rutaFicherosPY = "src\\main\\resources";
	
	public static void main(String[]args) {
		LanzadorPY lanzador = new LanzadorPY();
		lanzador.ejecutaprocesoPY();
	}
		
	
	public void ejecutaprocesoPY() {
		String[] comando = {"Python", rutaFicherosPY+"\\fichero.py"}; 
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
