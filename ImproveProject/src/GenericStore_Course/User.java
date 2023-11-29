package GenericStore_Course;

import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

class User implements Manageable {
	String id;
	String pwd;
	int point;
	ArrayList<Item> basket = new ArrayList<>();


	public void read(Scanner scan) {
		id = scan.next();
		pwd = scan.next();
		point = scan.nextInt(); // 1%
		int num = 0;
		Item item = null;
		while (true) {
			num = scan.nextInt();
			if (num == 0)
				break;
			item = Store.itemMgr.find("" + num);
			basket.add(item);
		}
	}

	public void print(boolean b) {
		System.out.format("[%s] (%d점)\n", id, point);
		if (b)
			return;
		for (Item item : basket) {
			System.out.print("   ");
			item.print();
		}
		System.out.println();
	}

	public void print() {
		print(false);
	}


	public boolean matches(String kwd) {
		if (id.equals(kwd))
			return true;
		return false;
	}

	boolean matches(String kwds[]) {
		for (String kwd : kwds) {
			if (kwd.charAt(0) == '-' && matches(kwd.substring(1)))
				return false;
			if (!matches(kwd))
				return false;
		}
		return true;
	}
}