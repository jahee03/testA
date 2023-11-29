package Team_Assignment;

import java.util.Scanner;

class Student {
	Department department = null;
	String name;
	int id;
	String myDepartment;
	int year;
	Team myTeam;

	Student(int id) {
		this.id = id;
	}

	void setTeam(Team t) {
		myTeam = t;
	}

	void read(Scanner scan) {
		// id = scan.nextInt();
		name = scan.next();
		myDepartment = scan.next();
		year = scan.nextInt();
	}

	boolean hasTeam() {
		if (myTeam == null)
			return true;
		return false;
	}

	void print() {
		if (hasTeam() == false)
			System.out.format("%d %s %s %d학년 [%s팀]\n", id, name, myDepartment, year, myTeam.teamName);

		else
			System.out.format("%d %s %s (%d학년)\n", id, name, myDepartment, year);
	}

	boolean matches(String kwd) {
		String id = "" + this.id;
		if (name.contains(kwd))
			return true;
		if (id.contains(kwd))
			return true;
		if (kwd.equals("" + year))
			return true;
		if (myDepartment.contains(kwd))
			return true;
		return false;
	}

	boolean matches(String[] kwds) {
		for (String kwd : kwds) {
			if (kwd.charAt(0) == '-' && matches(kwd.substring(1)))
				return false;
			if (matches(kwd))
				return false;
		}
		return true;
	}

}