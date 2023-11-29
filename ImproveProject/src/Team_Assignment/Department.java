package Team_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Team> teamList = new ArrayList<>();

	void run() {
		readAll();
		printAll();
		readTeams();
		printTeams();
		printAll();
	}

	void searchMenu() {
		int choice = 0;
		while (choice >= 0) {
			switch (choice) {
			case 0:
				System.out.println("0.메뉴 1.입력 2.검색 3.끝내기");
				choice = scan.nextInt();
				break;
			case 1:
				System.out.println("정보를 입력하세요");
				readAll();
				printAll();
				choice = 0;
				break;
			case 2:
				search();
				choice = 0;
				break;
			case 3:
				// searchTeams();
				choice = 0;
				break;
			default:
				break;
			}
		}
	}

	void readAll() {
		Student st = null;
		int id;
		while (true) {
			//for (int i = 0; i < 5; i++) {
				id = scan.nextInt();
				if (id == 0)
					break;
				st = new Student(id);
				st.read(scan);
				studentList.add(st);
			//}
		}
	}

	void readTeams() {
		Team t = null;
		String teamName = null;
		while (true) {
			teamName = scan.next();
			if (teamName.equals("end"))
				break;
			t = new Team(teamName);
			t.read(scan, this);
			teamList.add(t);
		}
	}

	void printAll() {
		for (Student st : studentList) {
			st.print();
		}
	}

	void printTeams() {
		for (Team t : teamList)
			t.print();
	}

	void search() {
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

	Student findStudent(int studentNumber) {
		if (studentNumber <= 0 || studentNumber > studentList.size())
			return null;
		return studentList.get(studentNumber - 1);
	}

	public static void main(String args[]) {
		Department department = new Department();
		department.run();
		department.search();
	}

}
