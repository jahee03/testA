package calory_Cou;

import java.util.Scanner;

import cmgr_Cou.Calory;


public class Food implements Calory {
	static int serialNo=0;
	int id;
	String type;
	String name;
	String unit;
	int cal;
	
	Food() {
		id = ++serialNo;
	}
	
	public void read(Scanner scan) {
		type = scan.next();
		name = scan.next();
		unit = scan.next();
		cal = scan.nextInt();
	}
	
	String calDetail(int n, String u) {
		// - 40kcal/1조각
		return String.format(" - %dkcal/1%s", cal, unit);
	}

	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals(name)) {
			return true;
		}
		if(kwd.contentEquals(type)) {
			return true;
		}
		return false;
	}

	@Override
	public void print() {
		System.out.format("[%2d] %s-%s (%dkcal/%s)"
				,id, type, name, cal, unit);
	}

	@Override
	public int getKcal(int num, String u) {
		return num*cal;
	}


	
}