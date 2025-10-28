package temperaturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AnalizadorTemperaturas {

	private static String rutaTxt = "src\\main\\resources\\temperaturas.txt";

	public static void main(String[] args) throws FileNotFoundException {
		int umbral = Integer.parseInt(args[0]);
		AnalizadorTemperaturas t = new AnalizadorTemperaturas();
		t.crearFicheroTemp();
		t.CalcularDiasCalor(rutaTxt, umbral);

	}

	// crear fichero
	public void crearFicheroTemp() {
		PrintWriter out = null;
		File f = new File(rutaTxt); 
		if (!f.exists()) {
			try {
				out = new PrintWriter(f);

				for (int i = 0; i < 20; i++) {
					int num = (int) (Math.random() * 51);
					System.out.println(num);
					out.println(num);
				}
				out.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// lee dias por encima y los escribe en un arhivo nuevo
	public void CalcularDiasCalor(String ruta, int umbral) throws FileNotFoundException {
		int cont = 0;
		Scanner in = null;
		PrintWriter out = null;
		File f = new File(ruta);
		File fparent = f.getParentFile();
		File fnuevo = new File(fparent, String.valueOf(umbral) + ".txt"); // crea un fichero umbral.txt a la misma
																			// altura que la ruta

		try {
			FileReader f1 = new FileReader(ruta);

			in = new Scanner(f1);
			out = new PrintWriter(fnuevo);
			while (in.hasNextLine()) {

				String linea = in.nextLine(); // lee una linea, la pasa a int y si supera el umbral dado lo cuenta.
				int num = Integer.parseInt(linea);
				if (num > umbral) {
					cont++;
				}
			}
			out.printf("Veces superado el umbral: " + cont , "%n");
		} finally {
			if (in != null) {
				in.close();
				out.close();
			}
		}
	}

}
