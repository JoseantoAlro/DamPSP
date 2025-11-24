package B1_Threads;

public class GestionaHilos {
	public static void main(String[] args){
		
		
		Hilo1 h1 = new Hilo1("Servicio");
		Hilo2 h2 = new Hilo2("proceso");
		
		
		
		h1.start();
		h2.start();
		
		
		
	}
}
