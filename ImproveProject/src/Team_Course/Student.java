package Team_Course;

import java.util.Scanner;

class Student {
	int id;
	String name;
	String myDepartment;
	int year;
	Team myTeam;
	Student(int id) {
		this.id = id;
	}

	void read(Scanner scan, Department department) {
		while (true) {
			name = scan.next();
			myDepartment = scan.next();
			year = scan.nextInt();
		}
	}

	void print() {
		System.out.format("%d %s (%d학년) [%s팀]\n", id, name, year, myTeam);
	}

	void setTeam(Team t) {
		myTeam = t;
	}

	boolean matches(String kwd) {
		if (kwd.equals(name))
			return true;
		if (kwd.equals("" + id))
			return true;
		return false;
	}

	boolean hasTeam(Team myTeam) {
		if (myTeam == null)
			return true;
		return false;

	}

}