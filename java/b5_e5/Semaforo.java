package b5_e5;

import java.util.concurrent.Semaphore;

public class Semaforo {
	private Semaphore semaforo;

	public Semaforo(int numeroConexiones) {
		semaforo = new Semaphore(numeroConexiones);
	}

	public void conexion() {
		try {
			semaforo.acquire();
			System.out.println(Thread.currentThread().getName() + " tiene conexión");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName() + " libera conexión");
		}
	}


	public void acquire(int i) throws InterruptedException {
		// TODO Auto-generated method stub
		semaforo.acquire();
	}

	public void release(int i) {
		// TODO Auto-generated method stub
		
	}
}
