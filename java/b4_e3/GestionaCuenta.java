package b4_e3;

import java.util.ArrayList;
import java.util.List;

public class GestionaCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta c = new Cuenta(700);
		
		List<CuentaHilosIngreso> lista = new ArrayList<>();
		CuentaHilosIngreso h1 = new CuentaHilosIngreso(c);
		CuentaHilosIngreso h2 = new CuentaHilosIngreso(c);
		CuentaHilosRetiro h3 = new CuentaHilosRetiro(c);
		CuentaHilosRetiro h4 = new CuentaHilosRetiro(c);
	
		h1.setDinero((int)(Math.random()*500+1));
		h1.start();
		h3.setDinero((int)(Math.random()*500+1));
		h3.start();
		h2.setDinero((int)(Math.random()*500+1));
		h2.start();
		h4.setDinero((int)(Math.random()*500+1));
		h4.start();
		
		
		try {
			h1.join();
			h3.join();
			h2.join();
			h4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("Saldo actual "+c.getDinero());
		
		
		
	}

}
