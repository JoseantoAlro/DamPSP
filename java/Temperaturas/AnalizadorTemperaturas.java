package Temperaturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class AnalizadorTemperaturas {

	String ruta = "src\\main\\resources\\temperaturas.txt";

	
	// crear fichero
	public void crearFicheroTemp() {
		PrintWriter out = null;
		File f = new File(ruta);
		if (!f.exists()) {
			try {
				f.createNewFile();
                out = new PrintWriter(new FileWriter(f));

                String temps = 
                        "12%n15%n8%n22%n25%n19%n30%n33%n28%n27%n35%n18%n21%n24%n26%n32%n" +
                        "29%n31%n14%n10%n9%n5%n23%n20%n22%n25%n27%n30%n33%n36%n38%n29%n" +
                        "26%n24%n19%n15%n11%n8%n6%n4%n3%n2%n0%n12%n18%n20%n22%n25%n28%n" +
                        "30%n35%n37%n40%n39%n31%n27%n26%n24%n20%n18%n17%n14%n11%n9%n7%n" +
                        "6%n5%n3%n2%n1%n0%n";

                out.printf(temps);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		//lee dias por encima y los escribe en un arhivo nuevo
	public int CalcularDiasCalor(String ruta, int umbral) throws FileNotFoundException {
		int cont = 0;
		Scanner in = null;
		PrintWriter out = null;
		File f = new File(ruta);
		File fparent = f.getParentFile();
		File fnuevo = new File(fparent,String.valueOf(umbral)+"txt");
		
		try {
			FileReader f1 = new FileReader(ruta); 

			in = new Scanner(f1);
			out = new PrintWriter(fnuevo);
			while (in.hasNextLine()) {
				
				String linea = in.nextLine();
				int num = Integer.parseInt(linea);
				if(num>umbral) {
					
					
				}
				
			}
		} finally{
			if (in != null) {
				in.close();
				out.close();
			}
		}
		return cont;
	}

	
}
