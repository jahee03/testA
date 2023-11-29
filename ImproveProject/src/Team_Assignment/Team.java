package Team_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	String teamName;
	ArrayList<Student> members = new ArrayList<>();
	Team(String name) {
		teamName = name;
	}
	void read(Scanner scan, Department department) {
		int studentNumber = 0;
		Student st = null;
		while (true) {
			studentNumber = scan.nextInt();
			if (studentNumber == 0)
				break;
			st = department.findStudent(studentNumber);
			members.add(st);
			st.setTeam(this);
		}
	}
	void print() {
		System.out.printf("%s: ", teamName);
		for (Student st: members) { 
			System.out.printf("%s ", st.name);
		}
		System.out.println();
	}
}
