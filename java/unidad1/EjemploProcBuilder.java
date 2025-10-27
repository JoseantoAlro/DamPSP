package unidad1;

import java.io.IOException;

public class EjemploProcBuilder {

	public static void main(String[]args) {
		
		String[] comando= {"C:/Program Files/Google/Chrome/Application/Chrome.exe", "https://www.google.com"};
		ProcessBuilder pb = new ProcessBuilder(comando);

		try {
			Process p1 = pb.start();
			Process p2 = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
	}
}
