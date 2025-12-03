package b5_e4;

public class PeticionesHilo extends Thread {
	private final Semaforo semaforo;

	public PeticionesHilo(Semaforo semaforo, String nombre) {
		super(nombre);
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		semaforo.conexion();
	}
}
