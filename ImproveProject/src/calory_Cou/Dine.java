package calory_Cou;

import java.util.Scanner;

import cmgr_Cou.Calory;
import cmgr_Cou.Manager;


public class Dine implements Calory {
	Scanner scan = new Scanner(System.in);
	
	int day, month;
	String eatType;
	int totalCal;
	
	Manager EatMgr = new Manager();
	
	@Override
	public void read(Scanner scan) {
		int num = 0;
		Eat e = null;
		month = scan.nextInt();
		day = scan.nextInt();
		eatType = scan.next();
		num = scan.nextInt();
		for(int i = 0;i<num;i++) {
			e = new Eat();
			e.read(scan);
			EatMgr.addElement(e);
		}
	}
	
	@Override
	public int getKcal(int num , String u) {
		return EatMgr.getTotalCalory();
	}

	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals(""+day)) {
			return true;
		}
		if(eatType.contains(kwd)) {
			return true;
		}
		return false;
	}

	@Override
	public void print() {
		totalCal = getKcal(0,"");
		System.out.format("%d/%d %s 총칼로리 : %dKcal\n",
				month, day, eatType, totalCal);
		EatMgr.printAll();
	}
}