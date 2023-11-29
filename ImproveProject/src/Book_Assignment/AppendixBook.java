package Book_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class AppendixBook extends Book {
	int volumes;
	ArrayList<String> titles = new ArrayList<>();

	@Override
	void read(Scanner scan) { // EBook
		super.read(scan);
		volumes = scan.nextInt();
		String tmp;
		for (int i = 0; volumes > i; i++) {
			tmp = scan.next();
			titles.add(tmp);
		}

	}

	@Override
	void print() {
		super.print();
		System.out.printf("%d", volumes);
		for (String a : titles)
			System.out.printf("%s ", a);
		System.out.println();
	}

	@Override
	void printBookType() {
		System.out.print("[부록책]");
	}

	@Override
	boolean matches(String kwd) {
		if (super.matches(kwd))
			return true;
		if (kwd.equals("부록책"))
			return true;
		return false;
	}

}
