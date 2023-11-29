package calory_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Dine {
	int day, month;
	String eatType;
	Eat eat = null;
	int totalCal = 0;
	ArrayList<Eat> eatlist = new ArrayList<>();

	Scanner scan = new Scanner(System.in);

	public Dine(int month) {
		this.month = month;
	}


	void readDine(int month) {
		System.out.println("q");
		day = scan.nextInt();
		eatType = scan.next();
		int cc = scan.nextInt();
		for (int i = 0; i < cc; i++) {
			readEats();
			System.out.println("p");
		}
		System.out.println("a");
	}

	void readEats() {
		Eat et = new Eat();
		Dines n =new Dines();
		et.read(scan, this, n );
		System.out.println("p");

		eatlist.add(et);
		totalCal += et.getKcal();
	}

	void printEats() {
		System.out.printf("%d/%d %s ", month, day, eatType);
		System.out.printf("총칼로리: %dkcal\n", totalCal);

		for (Eat f : eatlist)
			System.out.println("  " + f);
	}
}