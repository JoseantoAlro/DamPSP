package b3_e4;

public class MultiploCoopHilo2 extends Thread{
	private MultiplosCooperativos mult;

	
	
	public MultiploCoopHilo2(MultiplosCooperativos mult) {
		super();
		this.mult = mult;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		MultiplosCooperativos.multiplica(2);
	}
}
