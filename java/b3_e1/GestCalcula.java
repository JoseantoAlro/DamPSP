package b3_e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestCalcula {
	public static void main(String[] args) {
		
		List<int[]> tabla = new ArrayList<>();
		Random r = new Random();
		for (int i=0; i<1000; i++) {
			int rand = r.nextInt(500)+1;
			int[] elemento = {i,rand}; 
			tabla.add(elemento);
		}
		

		CalculaHilo h1 = new CalculaHilo(tabla,0,250);
		CalculaHilo h2 = new CalculaHilo(tabla,251,500);
		CalculaHilo h3 = new CalculaHilo(tabla,501,750);
		CalculaHilo h4 = new CalculaHilo(tabla,751, 999);
	
		
		//start, join
		
		//tengo cuatro valores compararlos
	}
}
