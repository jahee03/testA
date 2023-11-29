package Team_Course;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Team> teamList = new ArrayList<>();
	Team t;
	Student st;


	void run() {

		readAll();
		System.out.println("done");

		printAll();
		System.out.println("done");

		readTeams();
		System.out.println("done");

		printTeams();
		System.out.println("done");

		searchTeams();
		System.out.println("done");

		search();
		System.out.println("done");

	}

	void readAll() {
		System.out.println("readAll");
		int id;
		for (int i = 0; i < 5; i++) {
			id = scan.nextInt();
			if (id == 0) break;
			st = new Student(id);
			st.read(scan, this);
			studentList.add(st);
			System.out.print(st);

		}
	}

	void readTeams() {
		System.out.println("readTeams");

		String name;
		while (true) {
			name = scan.next();
			if (name.contentEquals("end"))
				break;
			t = new Team();
			t.read(scan, this);
			teamList.add(t);
		}
	}

	void printAll() {
		System.out.println("printAll");

		for (Student st : studentList) {
			st.print();
		}
	}

	void printTeams() {
		System.out.println("printTeams");

		for (Team t : teamList) {
			t.print();
		}
	}

	void search() {
		System.out.println("search");

		String kwd = null;
		while (true) {
			System.out.println("검색:");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (Student st : studentList) {
				if (st.matches(kwd))
					st.print();
			}
		}
	}

	void searchTeams() {
		System.out.println("searchTeams");

		String kwd = null;
		while (true) {
			System.out.println("검색:");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (Team t : teamList) {
				if (st.matches(kwd))
					t.print();
			}
		}

	}

	public Student findStudent(int studentNumber) {
		if (studentNumber <= 0 || studentNumber > studentList.size())
			return null;
		return studentList.get(studentNumber - 1);
	}

	public static void main(String args[]) {
		Department department = new Department();
		department.run();
	}
}
