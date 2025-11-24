package concurrencia;

public class CarreraEjemplo {

		   public static void main(String[] args) throws InterruptedException {
			   
			   long inicio = System.currentTimeMillis();
		       Contador contador = new Contador();
		       Thread t1 = new Thread(new TareaIncremento(contador));
		       Thread t2 = new Thread(new TareaIncremento(contador));
		       Thread t3 = new Thread(new TareaIncremento(contador));
		       Thread t4 = new Thread(new TareaIncremento(contador));
		       Thread t5 = new Thread(new TareaIncremento(contador));
		       Thread t6 = new Thread(new TareaIncremento(contador));
		       Thread t7 = new Thread(new TareaIncremento(contador));
		       Thread t8 = new Thread(new TareaIncremento(contador));
		       Thread t9 = new Thread(new TareaIncremento(contador));
		       t1.start();
		       t2.start();
		       t3.start();
		       t4.start();
		       t5.start();
		       t6.start();
		       t7.start();
		       t8.start();
		       t9.start();
		       t1.join();
		       t2.join();
		       t3.join();
		       t4.join();
		       t5.join();
		       t6.join();
		       t7.join();
		       t8.join();
		       t9.join();
		       System.out.println("Valor final: " + contador.getValor());
		       
		       long fin = System.currentTimeMillis(); // tiempo final
		       long duracion = fin - inicio;
		       System.out.println("Tiempo final: " + duracion+ "ms");
		   }
		}



class Contador {
	   private int valor = 0;
	   public synchronized void incrementar() { //sin sincro se pisan y no dan 9000
	       valor++;
	     
	   }
	   public int getValor() {
	       return valor;
	   }
	}
	class TareaIncremento implements Runnable {
	   private Contador contador;
	   public TareaIncremento(Contador contador) {
	       this.contador = contador;
	   }
	   @Override
	   public void run() {
	       for (int i = 0; i < 1000; i++) {
	           contador.incrementar();
	           try {
	   			Thread.sleep(1);
	   		} catch (InterruptedException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}
	       }
	   }
	}

