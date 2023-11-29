package Sort_Course;

import java.util.Scanner;

public class Lecture implements Manageable {
	String code;
	String lectureName;
	int year;
	String day;
	String time;
//
//	Lecture(String code) {
//		this.code = code;
//	}

	public void read(Scanner scan) {
		lectureName = scan.next();
		year = scan.nextInt();
		day = scan.next();
		time = scan.next();
	}

	public void print() {
		System.out.format("[%s] %s %d %s %s\n", code, lectureName, year, day, time);
	}

	public boolean matches(String kwd) {
		if (lectureName.contains(kwd))
			return true;
		if (code.contentEquals(kwd))
			return true;
		return false;
	}
}
