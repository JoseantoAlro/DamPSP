package ficheros;

import java.io.File;

public class GestionaLectores {
	
	private static final String Rutares = "src\\main\\resources\\";
	public static void main(String[]args) {
		
		Lector lect = new Lector();
		
		File fs = new File(Rutares);
		for(File f: fs.listFiles()) {
			lect.setarchivo(f);
			Thread h = new Thread(lect);
			h.start();
		}
	}
}
