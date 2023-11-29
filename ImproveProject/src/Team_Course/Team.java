package Team_Course;

import java.util.ArrayList;
import java.util.Scanner;

class Team {
	String name;
	ArrayList<Student> members = new ArrayList<>();
	Student st = null;

	void read(Scanner scan, Department department) {
		int studentNumber = 0;
		Student st = null;
		while (true) {
			studentNumber = scan.nextInt();
			if (studentNumber == 0)
				break;
			if (st.hasTeam(st.myTeam))
				continue;
			st = department.findStudent(studentNumber);
			members.add(st);
			st.setTeam(this);
		}
	}

	void print() {
		System.out.printf("%s: ", name);
		for (Student st : members) {
			System.out.printf("%s ", st.name);
			// System.out.println();
		}
	}

	boolean matches(String kwd) {
		if (kwd.contentEquals(name))
			return true;

		return false;
	}

}