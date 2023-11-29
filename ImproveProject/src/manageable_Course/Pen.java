package manageable_Course;

import java.util.Scanner;

class Pen implements Manageable {
	String itemName;
	float mmThick;
	int price;

	public void read(Scanner scan) {
		itemName = scan.next();
		mmThick = scan.nextFloat();
		price = scan.nextInt();

	}

	public void print() {
		System.out.printf("\t%s %fmm %d원\n", itemName, mmThick, price);
	}

	public boolean matches(String kwd) {
		if (itemName.contains(kwd))
			return true;
		if (kwd.equals("" + price))
			return true;
		if (kwd.equals("" + mmThick))
				return true;

		return false;
	}
}