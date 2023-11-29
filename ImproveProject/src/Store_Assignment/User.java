package Store_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class User implements Manageable {
	ArrayList<Order> myOrderList = new ArrayList<>();
	String userId;
	String pwd;
	int point;

	User(String id) {
		userId = id;
	}

	public void read(Scanner scan) {
		pwd = scan.next();
		point = scan.nextInt();
	}

	public void print() {
		System.out.printf("[%s] (%d점)\n", userId, point);
		for (Order order : myOrderList) {
			order.print(false);
		}
	}

	public boolean matches(String kwd) {
		if (userId.equals(kwd))
			return true;
		return false;
	}

	public void addOrder(Order order) {
		myOrderList.add(order);
		point+= order.point;

	}
}
