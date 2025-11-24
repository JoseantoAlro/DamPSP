package multihilos;

public class Mihilo extends Thread{
	
	private String nombreHilo;

	public Mihilo(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}
	
	
	@Override
	public void run() {
		System.out.println(this.nombreHilo + "estado:"+ this.getState());
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("salgo del hilo");
	}
}
