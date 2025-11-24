package multihilos;

public class Mihilo2 implements Runnable{
	private String nombreHilo;
	
	public Mihilo2(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(nombreHilo);
		System.out.println(this.nombreHilo);
		
		
		// TODO Auto-generated method stub
		
	}

}
