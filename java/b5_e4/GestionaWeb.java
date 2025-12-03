package b5_e4;

import java.util.ArrayList;
import java.util.List;

public class GestionaWeb {
	public static void main(String[] args) {

		Semaforo semaforo = new Semaforo(12);
		int numHilos = 20;

		List<Thread> hilos = new ArrayList<>();

		for (int i = 0; i < numHilos; i++) {
			hilos.add(new PeticionesHilo(semaforo, "peticion " + (i + 1)));
		}

		for (Thread hilo : hilos) {
			hilo.start();
		}
	}
}
