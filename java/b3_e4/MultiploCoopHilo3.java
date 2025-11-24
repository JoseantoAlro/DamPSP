package b3_e4;

public class MultiploCoopHilo3 extends Thread{
	private MultiplosCooperativos mult;

	
	
	public MultiploCoopHilo3(MultiplosCooperativos mult) {
		super();
		this.mult = mult;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		MultiplosCooperativos.multiplica(3);
	}
}
