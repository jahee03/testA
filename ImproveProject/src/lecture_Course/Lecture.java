package lecture_Course;

import java.util.Scanner;

public class Lecture {
	String code;
	String lectureName;
	int year;
	String day;
	String time;

	void read(Scanner scan) {
		lectureName = scan.next();
		year = scan.nextInt();
		day = scan.next();
		time = scan.next();
	}
	void print() {
		System.out.format("[%s] %s	%d %s %s\n",
				code, lectureName, year, day, time);
		}
	void match() {
		
	}

}
