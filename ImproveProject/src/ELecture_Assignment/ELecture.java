package ELecture_Assignment;

import java.util.Scanner;

public class ELecture extends Lecture {
	String url;

	@Override
	void read(Scanner scan, Department depart) {

		super.read(scan, depart);
		url = scan.next();

	}

	@Override
	void print() {
		super.print();
		System.out.printf("\t\t%s\n", url);

	}

	@Override
	boolean matches(String kwd) {
		if (super.matches(kwd))
			return true;
		if (url.contains(kwd))
			return true;
		return false;

	}

	ELecture(String code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	

}
