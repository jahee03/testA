package Manager_Course;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	ArrayList<Manageable> mList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	void readAll(String filename, Factory factory) {
		Scanner filein = openFile(filename);
		Manageable m = null;
		String id = null;
		while (filein.hasNext()) {
			id = filein.next();
			if (id.contentEquals("0"))
				break;
			m = factory.creat();
			m.read(filein, this);
			mList.add(m);
		}
		filein.close();
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

	void printAll() {
		for (Manageable m : mList)
			m.print();
	}

	void search() {
		String kwd = null;
		while (true) {
			System.out.print(">>");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (Manageable m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}

	public Manageable find(String kwd) {
		Manageable mSearch = null;
		for (Manageable m : mList)
			if (m.matches(kwd))
				mSearch = m;
		return mSearch;
	}
//	public Manageable find(String kwd) {
//		for (Manageable m : mList)
//			if (m.matches(kwd))
//				return m;
//		return null;
//	}
}