package DepartmentStudent_Course;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	void run() {
		readAll();
		printAll();
	}
	void readAll() {
		Student st = null;
		for (int i = 0; i < 5; i++) {
			st = new Student();
			st.read(scan);
			studentList.add(st);
		}
	}
	void printAll() {
		for (Student st : studentList) {
			st.print();
		}
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
	
	
	
	public static void main(String args[]) {
		Department department = new Department();
		department.run();
		department.search();
	}
	
}
