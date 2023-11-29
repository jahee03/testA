package Sort_Course;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager<T extends Manageable> {
	ArrayList<T> mList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	void readAll(String filename, Factory<T> factory) {
		Scanner filein = openFile(filename);
		T t = null;
		while (filein.hasNext()) {

			t = factory.create();
			t.read(filein);
			mList.add(t);
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

		for (T m : mList)
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

	public T find(String kwd) {
		T mSearch = null;
		for (T m : mList)
			if (m.matches(kwd))
				mSearch = m;
		return mSearch;
	}
}
