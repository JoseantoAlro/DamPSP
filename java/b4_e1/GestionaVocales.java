package b4_e1;

public class GestionaVocales {
	
	public static void main(String[]args) throws InterruptedException {
		String txt = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaasddddds e i";
		CuentaVocales cc = new CuentaVocales();
		
		ContarVocalHilo h1 = new ContarVocalHilo(cc, txt, 'a' );
		ContarVocalHilo h2 = new ContarVocalHilo(cc, txt, 'i' );
		ContarVocalHilo h3 = new ContarVocalHilo(cc, txt, 'e' );
		h1.start();
		h2.start();
		h3.start();
		h1.join();
		h2.join();
		h3.join();
		System.out.println(cc.getVocalesTotales());
	}
}
