package b5_e5;

public class Cocinero extends Thread {
	private final Semaforo semaforo;

	public Cocinero(Semaforo semaforo, String nombre) {
		super(nombre);
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Cocinando");
				Thread.sleep(2000);
				semaforo.release(3);
				System.out.println("Cocinado");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
