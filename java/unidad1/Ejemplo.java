package unidad1;

import java.io.IOException;

public class Ejemplo {
	
	public static void main(String[]args) {
		Runtime kernel = Runtime.getRuntime();
		
		
		System.out.print(kernel.totalMemory());
		System.out.print(kernel.maxMemory());
		System.out.print(kernel.freeMemory());
		//String[] argumentos= {"C:/Program Files/Google/Chrome/Application/Chrome.exe", "https://www.google.com"};
		String[] argumentos={"NotePad.exe"};
		Process proceso;
		/*try {
			kernel.exec(argumentos);
			System.out.println("---Después del wait);
		}catch (IOException e) {
			e.printStackTrace();
		}*/
		try {
			proceso =kernel.exec(argumentos);
			int codigoRetorno = proceso.waitFor();
			System.out.println("---llego al final "+codigoRetorno);
		}catch (IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//process builder
	}
}
