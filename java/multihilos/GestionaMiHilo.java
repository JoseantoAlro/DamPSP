package multihilos;

public class GestionaMiHilo {

    public static void main(String[] args) throws InterruptedException{
        Mihilo hilo1 = new Mihilo("hilo1");
        System.out.println(hilo1.getState());	
        Mihilo hilo2 = new Mihilo("hilo2");

        long inicio = System.currentTimeMillis(); // tiempo inicial

        hilo1.start();
        hilo2.start();

        System.out.println("En el main (antes de join)");
        System.out.println("Estado hilo1: " + hilo1.getState());
        System.out.println("Estado hilo2: " + hilo2.getState());

        try {
            // 🔹 Esperar a que los dos hilos terminen
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis(); // tiempo final
        long duracion = fin - inicio;

        System.out.println("Los hilos han terminado.");
        System.out.println("El programa tardó " + duracion + " ms");
    	
/*
		Mihilo2 hilorun1 = new Mihilo2("Hilo1");
		Mihilo2 hilorun2 = new Mihilo2("Hilo2");
		hilorun1.run();
		System.out.println("hilo terminado");
		
*/
	}

}
