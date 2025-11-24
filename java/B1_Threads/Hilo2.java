package B1_Threads;

public class Hilo2 extends Thread{
	private String nombreHilo;

	public Hilo2(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				sleep(500);
				System.out.println("PRODUCTOS");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
