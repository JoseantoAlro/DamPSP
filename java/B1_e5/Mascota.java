package B1_e5;

public class Mascota implements Runnable{
	private String nombre;
	private int comidas;
	public Mascota(String nombre, int comidas) {
		super();
		this.nombre = nombre;
		this.comidas = comidas;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getComidas() {
		return comidas;
	}

	public void setComidas(int comidas) {
		this.comidas = comidas;
	}

	public void comer() {
		
		try {
			System.out.println(Thread.currentThread().getName() + " le hecha de come");
			System.out.println(this.nombre + " empiza a comer");
			comidas++;
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + nombre+" ha terminado de comer");
	}
	

	@Override
	public void run() {
		this.comer();
		
	}
	
	
}
