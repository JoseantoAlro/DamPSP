package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Lector implements Runnable{
	private File archivo;
	private int caracteres;
	
	
	
	
	public Lector(File ruta, int caracteres) {
		super();
		this.archivo = ruta;
		this.caracteres = caracteres;
	}
	



	public Lector() {
		super();
	}




	public File getarchivo() {
		return archivo;
	}




	public void setarchivo(File ruta) {
		this.archivo = ruta;
	}




	public int getCaracteres() {
		return caracteres;
	}




	public void setCaracteres(int caracteres) {
		this.caracteres = caracteres;
	}




	public int contar() throws FileNotFoundException {
		int cont=0;
		Scanner in=null;
		try {
			FileReader f = new FileReader(archivo);
			in = new Scanner(f);
			while(in.hasNextLine()) {
				String linea = in.nextLine();
				cont += linea.length();
				
			}
		}finally{
			if (in != null) {
				in.close();
			}
			
		} 
		return cont;
	}




	@Override
	public void run() {
		try {
			
			System.out.println("el archivo "+ archivo.getName()+ " tiene "+this.contar()+" caracteres");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
