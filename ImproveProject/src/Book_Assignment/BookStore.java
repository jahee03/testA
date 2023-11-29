package Book_Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class BookStore {
	Scanner scan = new Scanner(System.in);
	ArrayList<Book> bookList = new ArrayList<>();

	void run() {
		readAllBooks("book3.txt");
		printAllBooks();
		search();
	}

	void readAllBooks(String filename) {
		Scanner filein = openFile(filename);
		Book book = null;
		int type = 0;
		while (filein.hasNext()) {
			type = filein.nextInt();
			switch (type) {
			case 1:
				book = new Book();
				break;
			case 2:
				book = new EBook();
				break;
			case 3:
				book = new AppendixBook();
			default:
				type = 0;
				break;
			}
			book.read(filein);
			bookList.add(book);
		}
		filein.close();

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

	void printAllBooks() {
		if (bookList.isEmpty())
			System.out.print("bad");
		for (Book book : bookList)
			book.print();
	}

	void search() {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (Book b: bookList) {
				if (b.matches(kwd))
					b.print();
			}
		}
	}

	public static void main(String arg[]) {
		BookStore store = new BookStore();
		store.run();
	}
}
