package b3_e1;

import java.util.List;

public class CalculaHilo implements Runnable {
	private List<int[]> tabla;
	private int inicio;
	private int fin;
	private int[] puntoMaximo;
	
	
	
	
	



	public CalculaHilo(List<int[]> tabla, int inicio, int fin) {
		super();
		this.tabla = tabla;
		this.inicio = inicio;
		this.fin = fin;
	}



	public int[] getPuntoMaximo() {
		return puntoMaximo;
	}



	public void setPuntoMaximo(int[] puntoMaximo) {
		this.puntoMaximo = puntoMaximo;
	}



	public int[] CalculaValor() {
		int actual=0;
		int pos=0;
		int max[];
		for(int i= inicio; i>=fin;i++ ) {
			if(tabla.get(i)[1]>actual) {
				actual=tabla.get(i)[1];
				pos=i;
			}
		}
		max = new int[] { pos, actual };
		return max;
	}
	
	
	
	@Override
	public void run() {
		puntoMaximo = CalculaValor();
		
	}

}
