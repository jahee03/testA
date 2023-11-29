package calory_Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	ArrayList<Manageable> mList = new ArrayList<>();

	Scanner scan = new Scanner(System.in);

//
//	void readEats() {
//		month = scan.nextInt();
//		day = scan.nextInt();
//		eatType = scan.next();
//		int cc = scan.nextInt();
//		for (int i = 0; i < cc; i++) {
//			Eat et = new Eat();
//			et.read(scan, this);
//			eatlist.add(et);
//			totalCal += et.getKcal();
//		}
//	}
//
//
//	void readFoods() {
//		Food m = null;
//		String type;
//		while (true) {
//			type = scan.next();
//			if (type.equals("0"))
//				break;
//			m = new Food(type);
//			m.read(scan, this);
//			foods.add(m);
//			foodMap.put(m.name, m);
//			System.out.println(m);
//		}
//	}
//
//	void readAll(String filename, Factory factory) {
//		Scanner filein = openFile(filename);
//		Manageable m = null;
//		String id = null;
//		while (filein.hasNext()) {
//			id = filein.next();
//			if (id.contentEquals("0"))
//				break;
//			m = factory.creat();
//			m.read(filein, this);
//			mList.add(m);
//		}
//		filein.close();
//	}
//
//	Scanner openFile(String filename) {
//		Scanner filein = null;
//		try {
//			filein = new Scanner(new File(filename));
//		} catch (IOException e) {
//			System.out.println("파일 입력 오류");
//			System.exit(0);
//		}
//		return filein;
//
//	}
//
//	void printAll() {
//		for (Manageable m : mList)
//			m.print();
//	}
////
//	void search() {
//		String kwd = null;
//		while (true) {
//			System.out.print(">>");
//			kwd = scan.next();
//			if (kwd.equals("end"))
//				break;
//			for (Manageable m : mList) {
//				if (m.matches(kwd))
//					m.print();
//			}
//		}
//	}
//
//	public Manageable find(String kwd) {
//		Manageable mSearch = null;
//		for (Manageable m : mList)
//			if (m.matches(kwd))
//				mSearch = m;
//		return mSearch;
//	}
}