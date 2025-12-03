package b4_e3;

public class Cuenta {
	private double dinero;

	public Cuenta(double dinero) {
		super();
		this.dinero = dinero;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	public synchronized void retirardinero(double i) {
		if (this.getDinero()<i) {
			System.out.println("falta dinero fiera");
		}else {
			System.out.println(" balance de "+this.getDinero()+" pasa a "+ (this.getDinero()-i));
			this.setDinero(this.getDinero()-i);
		}
		
	}
	public synchronized void ingresaDinero(double i) {
		System.out.println(" balance de "+this.getDinero()+" pasa a "+ (this.getDinero()+i));
		this.setDinero(this.getDinero()+i);
	}
}
