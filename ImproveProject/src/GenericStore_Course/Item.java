package GenericStore_Course;

import java.util.Scanner;

import mgr.Manageable;

public class Item implements Manageable, Comparable<Item> {

	int num;
	static int count = 0;
	String code;
	String name;
	int price;
//
//	Lecture(String code) {
//		this.code = code;
//	}

	public void read(Scanner scan) {
		num = ++count;
		code = scan.next();
		name = scan.next();
		price = scan.nextInt();
	}

	public void print() {
		System.out.printf("[%s] %s\t", code, name);
		System.out.printf("%5d원\n", price);
	}

	public boolean matches(String kwd) {
		if (kwd.length() <= 2 && kwd.equals("" + num))
			return true;
		if (name.contains(kwd))
			return true;
		if (kwd.length() > 2 && code.contains(kwd))
			return true;
		return false;
	}

	@Override
	public void print(boolean b) {
		print();
	}

	@Override
	public int compareTo(Item other) {
//		if (code other.code)
//			return 1;
//		if (code < other.code)
//			return -1;
		if (!name.equals(other.name))
			return name.compareTo(other.name);
//		if (id > other.id) return 1;
//		if (id < other.id) return -1;
		return 0;
	}
}
