package calory_Cou;

import java.util.Scanner;

import cmgr_Cou.Calory;


public class DetailFood extends Food implements Calory {
	int volume;
	String volume_unit;

	@Override
	public void read(Scanner scan) {
		super.read(scan);
		volume = scan.nextInt();
		volume_unit = scan.next();
	}

	@Override
	public int getKcal(int qnty, String u) {
		if(u.contentEquals(volume_unit))
			return (cal*qnty)/volume;
		return super.getKcal(qnty, u);
	}

//	@Override
//	String getDetail() {
//		//[ 3] 과자-감자칩 (544kcal/봉) 108g
//		return String.format(" %d%s", volume, volume_unit);
//	}
	
	@Override
	String calDetail(int qnty, String u) { 
		// -> 40kcal*60/20g=120kcal
		return String.format(" -> %dkcal*%d/%d%s=%dkcal", cal, qnty, volume, volume_unit, getKcal(qnty, u));
	}

	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return super.matches(kwd);
	}

	@Override
	public void print() {
		super.print();
		System.out.format(" %d%s", volume, volume_unit);
	}
	
	

}
