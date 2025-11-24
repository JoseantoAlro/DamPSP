package B1_e5;

import java.util.ArrayList;
import java.util.List;

public class GestionaMascota {
	
	
	
	public static void main(String[]args) {
		Mascota m = new Mascota("lulu",0);
		
		
		/*
		Thread c1 = new Thread(m, "paco");
		Thread c2 = new Thread(m, "paco");
		Thread c3 = new Thread(m, "paco");
		Thread c4 = new Thread(m, "paco");
		Thread c5 = new Thread(m, "paco");
		
		
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		
		try {
			c1.join();
			c2.join();
			c3.join();
			c4.join();
			c5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("veces comido: " +m.getComidas());
		
		
		*/
		
		
		List<Thread> hilos = new ArrayList<Thread>();
		
		for(int i=0; i<10; i++) {
			Thread t = new Thread(m, "c"+i);
			t.setPriority(i+1);
			t.start();
			hilos.add(t);
		}
		
		
		for(Thread t:hilos) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("veces comido: " +m.getComidas());
		
		
	}
}
