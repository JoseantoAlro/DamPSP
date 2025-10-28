package unidad1;

import java.io.IOException;
import java.util.Scanner;

public class listarProcesosBuilder {

	
	public static void main(String[]args) {

		
		String[] comando= {"cmd.exe", "/c", "start", "cmd.exe","/k", "tasklist"};
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		try {
			Process p1 = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
