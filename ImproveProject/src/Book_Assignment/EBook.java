package Book_Assignment;

import java.util.Scanner;

public class EBook extends Book {

	String url;
	String format;

	@Override
	void read(Scanner scan) { // EBook
		super.read(scan);
		url = scan.next();
		format = scan.next();
	}

	@Override
	void print() {
		super.print();
		System.out.printf("%s [%s]\n", url, format);
	}

	@Override
	void printBookType() {
		System.out.print("[전자책]");
	}

	@Override
	boolean matches(String kwd) {
		if (super.matches(kwd))
			return true;
		if (url.contains(kwd))
			return true;
		if (format.equals(kwd))
			return true;
		if (kwd.equals("전자책"))
			return true;
		return false;
	}

}
