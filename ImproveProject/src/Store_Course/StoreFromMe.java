package Store_Course;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreFromMe {
	Scanner scan = new Scanner(System.in);
	static ArrayList<Manageable> itemList = new ArrayList<>();
	static ArrayList<Manageable> userList = new ArrayList<>();

	void run() {
		readAll(itemList, "item.txt", "item");
		readAll(userList, "user.txt", "user");
		menu();
		// findItem();
	}

	void menu() {
		int num;
		while (true) {
			System.out.print("(1)물품출력 (2)사용자출력 (3)검색 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 3)
				break;
			switch (num) {
			case 1:
				printAll(itemList);
				break;
			case 2:
				printAll(userList);
				break;
			case 4:
				searchMenu();
				break;
			default:
				break;
			}
		}
	}

	void searchMenu() {
		int num;
		while (true) {
			System.out.print("(1)물품검색 (2)사용자검색 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 2)
				break;
			switch (num) {
			case 1:
				searchAll(itemList);
				break;
			case 2:
				searchAll(userList);
				break;
			default:
				break;
			}
		}
	}

	void searchAll(ArrayList<Manageable> mlist) {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			if (kwd.contentEquals("end"))
				break;
			for (Manageable m : mlist) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}

	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("파일 입력 오류");
			System.exit(0);
		}
		return filein;
	}

	void readAll(ArrayList<Manageable> mlist, String filename, String type) {
		Scanner filein = openFile(filename);
		Manageable m = null;
		switch (type) {
		case "item":
			while (filein.hasNext()) {
				m = new Item();
				m.read(filein);
				mlist.add(m);
			}
			break;
		case "user":
			while (filein.hasNext()) {
				m = new User();
				m.read(filein);
				mlist.add(m);
			}
			break;
		default:
			break;
		}
	}

	static Item findItem(String kwd) {
		for (Manageable m : itemList) {
			if (m.matches(kwd))
				return (Item) m;// 강제형전환

		}
		return null;
	}

	void printAll(ArrayList<Manageable> mlist) {
		for (Manageable m : mlist) {
			m.print();
		}
	}

}
