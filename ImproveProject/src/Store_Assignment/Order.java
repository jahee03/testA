package Store_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Order implements Manageable {
	String id;
	User user;
	Item item;
	String date;
	int total;
	int point;

	ArrayList<Item> orderedItemList = new ArrayList<>();
	ArrayList<Integer> orderedItemCount = new ArrayList<>();

	public Order(String id) {
		this.id = id;
	}

	public void print() {
		print(true);
	}

	public void print(boolean bDetail) {
		System.out.printf("[주문아이디:%s] %s 사용자: %s", id, date, user.userId);
		System.out.printf(" - 주문금액:%5d 포인트:%2d점)\n", total, point);
		if (bDetail)
			return;
		for (int i = 0; i < orderedItemList.size(); i++) {
			System.out.printf("\t(%2d개) ", orderedItemCount.get(i));
			orderedItemList.get(i).print();
		}
	}

	public void read(Scanner scan2) {
		String userId = scan2.next();
		user = Store.findUser(userId);
		user.addOrder(this);
		date = scan2.next();

		while (true) {
			String itemId = scan2.next();
			if (itemId.equals("0"))
				break;
			item = Store.findItem(itemId); 
			if (item == null) {
				System.out.printf("ItemId Error:%s", itemId);
				continue;
			}
			orderedItemList.add(item);
			orderedItemCount.add(scan2.nextInt());
		}
		calsTotal();
		point = total / 1000;
		user.addOrder(this);
	}

	void calsTotal() {
		for (int i = 0; i < orderedItemList.size(); i++) {
			total += orderedItemList.get(i).getSubtotal(orderedItemCount.get(i));

		}
	}

	@Override
	public boolean matches(String kwd) {
		if(date.equals(kwd))
			return true;
		if (id.equals(kwd))
			return true;
		return false;
	}

}
