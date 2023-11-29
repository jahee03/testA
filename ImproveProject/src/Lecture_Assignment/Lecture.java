package Lecture_Assignment;

import java.util.Scanner;

public class Lecture {
	String code;
	String lectureName;
	int year;
	String day;
	String time;

	Lecture(String code) {
		this.code = code;
	}

	void read(Scanner scan, Department department) {
		lectureName = scan.next();
		year = scan.nextInt();
		day = scan.next();
		time = scan.next();
	}

	void print() {
		System.out.format("[%s] %s %d %s %s\n", code, lectureName, year, day, time);
	}

	boolean matches(String kwd) {
		if (lectureName.contains(kwd))
			return true;
		if (kwd.equals(code))
			return true;
		return false;
	}
}
