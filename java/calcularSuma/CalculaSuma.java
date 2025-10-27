package calcularSuma;

public class CalculaSuma {

	public static void main(String[] args) {
		String par = args[0];
		int num = Integer.parseInt(args[1]);	
		System.out.println(lanzaSuma(par,num));
	}
	
	
	
	public static int lanzaSuma(String par, int num) {
		int suma=0;
		if (par.equals("par")) {
			for(int i=0; i<=num; i++) {
				if (i%2==0) {
					suma=suma+i;
				}
			}
		}
		else if(par.equals("impar")) {
			for(int i=0; i<=num; i++) {
				if (i%2 != 0) {
					suma=suma+i;
				}
			}
		}
		return suma;
	}
}
