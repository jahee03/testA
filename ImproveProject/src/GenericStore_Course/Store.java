package GenericStore_Course;

//import java.util.Collections;

import mgr.Factory;
import mgr.Manager;

class Store {
	static Manager<Item> itemMgr = new Manager<>();
	static Manager<User> userMgr = new Manager<>();

	public static void main(String args[]) {
		Store main = new Store();
		main.run();
	}

	void run() {
		itemMgr.readAll("Items.txt", new Factory<Item>() {
			public Item create() {
				return new Item();
			}
		});
//		Collections.sort(itemMgr.mList, new Comparator<Item>() {
//			public int compare(Item item1, Item item2) {
//				return item1.price - item2.price;
//			}
//		});
		itemMgr.printAll();
		userMgr.readAll("user-info.txt", new Factory<User>() {
			public User create() {
				return new User();
			}
		});
//		stMgr.readAll("student.txt", new StudentFac());
//		stMgr.readAll("student.txt", () -> new Student());
//		stMgr.readAll("student.txt", Student::new);
		userMgr.printAll();
	}

//	void itemsort() {
//		Collections.sort(itemMgr.mList);
//
//	}
}