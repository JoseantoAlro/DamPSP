package b3_e4;

public class MultiplosCooperativos {

	
	
	
	public static synchronized void multiplica(int ini) {

		for (int i=1; i<=10; i++) {
			System.out.println(ini+"*"+i+"="+i*ini);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
