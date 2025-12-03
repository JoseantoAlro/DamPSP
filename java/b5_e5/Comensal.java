package b5_e5;



public class Comensal extends Thread{
	private final Semaforo semaforo;

	public Comensal(Semaforo semaforo, String nombre) {
		super(nombre);
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		System.out.println("comiendo");
		
	}
}


