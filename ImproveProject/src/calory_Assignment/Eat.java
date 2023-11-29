package calory_Assignment;

import java.util.Scanner;

class Eat {
	Food food;
	int qnty;
	String unit;
	int kcal;
	void read(Scanner scan, Dine main, Dines main2) {
		String name = scan.next();
		food = main2.findFood(name);
		qnty = scan.nextInt();
		kcal = getKcal();
		unit = food.unit;
	}
	@Override
	public String toString() {
		return String.format("%s %d%s(%dkcal) - %s", 
				food.name, qnty, unit, kcal, food.getDetail(qnty, unit));
	}
	int getKcal() {
		return food.getKcal(qnty,  unit);
	}
}