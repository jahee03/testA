package Store_Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Store {
	Scanner scan = new Scanner(System.in);
	static ArrayList<Manageable> itemList = new ArrayList<>();
	static ArrayList<Manageable> userList = new ArrayList<>();
	static ArrayList<Manageable> orderList = new ArrayList<>();

	void run() {
		readAllFile("items.txt", itemList, "item");
		readAllFile("user-info.txt", userList, "user");
		readAllFile("order.txt", orderList, "order");
		menu();
	}

	void menu() {
		int num;
		while (true) {
			System.out.print("(1)물품출력 (2)사용자출력 (3)주문출력 (4)검색 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 4)
				break;
			switch (num) {
			case 1:
				printAll(itemList);
				break;
			case 2:
				printAll(userList);
				break;
			case 3:
				printAll(orderList);
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
			System.out.print("(1)물품검색 (2)사용자검색 (3)주문검색 (4)평균구매금액검색 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 4)
				break;
			switch (num) {
			case 1:
				searchAll(itemList);
				break;
			case 2:
				searchAll(userList);
				break;
			case 3:
				searchAll(orderList);
				break;
			default:
				break;
			}
		}
	}

	void searchAll(ArrayList<Manageable> mList) {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			if (kwd.contentEquals("end"))
				break;
			for (Manageable m : mList) {
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

	void readAllFile(String filename, ArrayList<Manageable> mList, String type) {
		Scanner filein = openFile(filename);
		Manageable m = null;
		String id = null;
		while (filein.hasNext()) {
			id = filein.next();
			if (id.contentEquals("0"))
				break;
			switch (type) {
			case "item":
				m = new Item(id);
				m.read(filein);
				mList.add(m);
				break;
			case "user":
				m = new User(id);
				m.read(filein);
				mList.add(m);
				break;
			case "order":
				m = new Order(id);
				m.read(filein);
				mList.add(m);
				break;
			default:
				break;
			}

		}
	}

	static Manageable find(String kwd, ArrayList<Manageable> mList) {
		for (Manageable m : mList) {
			if (m.matches(kwd))
				return m;
		}
		return null;
	}

	void printAll(ArrayList<Manageable> mList) {
		for (Manageable m : mList) {
			m.print();
		}
	}

	static Item findItem(String kwd) {
		return (Item) find(kwd, itemList);
	}

	static User findUser(String userId) {
		return (User) find(userId, userList);
	}

	public static void main(String[] args) {
		Store m = new Store();
		m.run();
	}

}
