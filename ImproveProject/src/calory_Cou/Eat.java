package calory_Cou;

import java.util.Scanner;

import cmgr_Cou.Calory;


class Eat implements Calory {
	Food food;
	int qnty;
	String unit;
	int kcal;
	
	public void read(Scanner scan) {
		String name = scan.next();
		food = (Food)CaloryMgr.foodMgr.find(name);
		qnty = scan.nextInt();
		unit = scan.next();
		kcal = getKcal(qnty,unit);
	}
	
	public int getKcal(int num, String u) {
		return food.getKcal(qnty, unit);
	}

	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals(unit)) {
			return true;
		}
		return false;
	}

	@Override
	public void print() {
		// 비스켓 60g(120kcal) - 40kcal/1조각 -> 40kcal*60/20g=120kcal
		System.out.format("%s %d%s(%dkcal) %s", 
				food.name, qnty, unit, kcal, food.calDetail(qnty, unit));
	}

}