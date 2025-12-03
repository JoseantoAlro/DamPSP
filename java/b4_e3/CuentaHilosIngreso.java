package b4_e3;

public class CuentaHilosIngreso extends Thread{
	private Cuenta c;
	private double dinero;

	


	public CuentaHilosIngreso(Cuenta c) {
		super();
		this.c = c;
	}
	
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	@Override
	public void run() {

		this.c.ingresaDinero(dinero);
	}
}
