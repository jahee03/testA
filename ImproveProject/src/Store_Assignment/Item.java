package Store_Assignment;

import java.util.Scanner;

public class Item implements Manageable {
	String id;
	String name;
	int price;

	Item(String id2) {
		id = id2;
	}

	public void read(Scanner scan) {
		name = scan.next();
		price = scan.nextInt();
	}

	static String fillLength(String origin, int len) {
		StringBuilder buil = new StringBuilder(origin);
		for (int i = origin.getBytes().length; i < len; i++)
			buil.append(' ');
		return buil.toString();
	}

	public void print() {
		System.out.printf("[%s] %s\t", id, name);
		System.out.printf("%d원\n", price);
	}

	public boolean matches(String kwd) {
		if (name.contains(kwd))
			return true;
		if (kwd.length() > 2 && id.contains(kwd))
			return true;
		return false;
	}

	int getSubtotal(int count) {
		return price * count;
	}

}