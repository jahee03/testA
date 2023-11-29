package calory_Cou;


import java.util.Scanner;

import cmgr_Cou.Calory;
import cmgr_Cou.Factory;
import cmgr_Cou.Manager;

public class CaloryMgr {
	static Manager foodMgr = new Manager();
	Manager dineMgr = new Manager();
	

	
	void run() {
		foodMgr.readAll("foods.txt", new Factory() {
			public Calory create(Scanner scan) {
				int n = scan.nextInt();
				if (n == 1) return new Food();
				return new DetailFood();
			}
		});
		foodMgr.printAll();
		System.out.println();
		dineMgr.readAll("dine.txt", new Factory() {
			public Calory create(Scanner scan) {
				return new Dine();
			}
		});
		dineMgr.printAll();
	}
	
	public static void main(String[] args) {
		CaloryMgr calmg = new CaloryMgr();
		calmg.run();
	}
}
