package manageable_Course;

import java.util.Scanner;

class Tissue implements Manageable {
	String tissueName;
	int nSheets;
	int price;

	public void read(Scanner scan) {
		tissueName = scan.next();
		nSheets = scan.nextInt();
		price = scan.nextInt();

	}

	public void print() {
		System.out.printf("\t%s %d매 %d원\n", tissueName, nSheets, price);
	}

	public boolean matches(String kwd) {
		if (tissueName.contains(kwd))
			return true;
		if (kwd.equals("" + nSheets))
			return true;
		if (kwd.equals("" + price))
			return true;
		return false;
	}
}