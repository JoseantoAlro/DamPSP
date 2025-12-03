package b4_e3;

public class CuentaHilosRetiro extends Thread{
		private Cuenta c;
		private double dinero;

		


		public CuentaHilosRetiro(Cuenta c) {
			super();
			this.c = c;
		}

		public void setDinero(double dinero) {
			this.dinero = dinero;
		}
		
		@Override
		public void run() {
			this.c.retirardinero(dinero);
		}
	
}
