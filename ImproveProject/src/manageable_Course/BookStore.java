package manageable_Course;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
	Scanner scan = new Scanner(System.in);
	ArrayList<Manageable> sellList = new ArrayList<>();


	void run() {
		readAll("book4.txt");
		printAll();
		search();
	}
	
	
	void readAll(String filename) {
		Scanner filein = openFile(filename);
		Manageable item = null;
		while (filein.hasNext()) {
			int type = filein.nextInt();
			switch (type) {
			case 1:
				item = new Book();
				break;
			case 2:
				item = new EBook();
				break;
			case 3:
				item = new ABook();
				break;
			case 4:
				item = new Pen();
				break;
			case 5:
				item = new Tissue();
				break;
			default:
				break;
			}
			item.read(filein);
			sellList.add(item);
		}
	}
	
	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("파일오픈실패" + filename);
			System.exit(0);
		}
		return filein;
	}

	void printAll() {
		for (Manageable m : sellList)
			m.print();
		System.out.println();
	}



	void search() {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			for (Manageable b : sellList)
				if (b.matches(kwd))
					b.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookStore store = new BookStore();
		store.run();
	}

}
