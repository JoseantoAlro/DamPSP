package b5_e5;

import java.util.ArrayList;
import java.util.List;


public class GestionaRestaurante {
	public static void main(String[] args) {
		List<Thread> hilos = new ArrayList<>();
		Semaforo semaforoCocina = new Semaforo(3);
		try {
			semaforoCocina.acquire(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cocinero c1 = new Cocinero(semaforoCocina, "cocinero");
		int numHilos = 3;

		
		hilos.add(c1);
		for (int i = 0; i < numHilos; i++) {
			hilos.add(new Comensal(semaforoCocina, "comensal " + (i + 1)));
		}

		for (Thread hilo : hilos) {
			hilo.start();
		}
	}
}
