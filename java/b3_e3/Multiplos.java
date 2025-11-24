package b3_e3;

public class Multiplos implements Runnable{
	private int numero;
	
	
	public Multiplos(int numero) {
		super();
		this.numero = numero;
	}

	
	public void multiplica(int ini) {

		for (int i=1; i<=10; i++) {
			System.out.println(i*ini);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		multiplica(numero);

	}

}
