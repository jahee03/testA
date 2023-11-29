package Book_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {

	String title;
	String pub;
	int isbn;
	int year;
	int price;
	ArrayList<String> Authors = new ArrayList<>();

	void read(Scanner scan) {
		title = scan.next();
		pub = scan.next();
		isbn = scan.nextInt();
		year = scan.nextInt();
		String tmp;
		while (true) {
			tmp = scan.next();
			if (tmp.contentEquals("0"))
				break;
			Authors.add(tmp);
		} // 저자 여러명을 읽는 부분
		price = scan.nextInt();

	}

	void print() {
		printBookType();
		System.out.printf("%s (%s/%s/%d년) [%d원] 저자:", title, pub, isbn, year, price);
		for (String a : Authors)
			System.out.printf("%s ", a);
		System.out.println();
	}

	void printBookType() {
		System.out.print("[일반책]");
	}

	boolean matches(String kwd) {
		if (title.contains(kwd))
			return true;
		if (pub.equals(kwd))
			return true;
		if (kwd.equals("" + isbn))
			return true;
		if (kwd.equals("" + year))
			return true;
		for (String a : Authors) 
		{
			if (a.contentEquals(kwd))
				return true;
		}
		return false;
	}

}
