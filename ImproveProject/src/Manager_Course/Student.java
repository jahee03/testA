package Manager_Course;

import java.util.ArrayList;
import java.util.Scanner;

class Student implements Manageable {
	String name;
	String id;
	String phone;
	int year;
	Lecture lecture = null;

//	Student(String id2) {
//		this.id = id2;
//	}

	ArrayList<Lecture> registeredList = new ArrayList<>();

	public void read(Scanner scan, Manager manager) {
		id = scan.next();
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
		String code;
		while (true) {
			code = scan.next();
			if (code.equals("0"))
				break;
			lecture = (Lecture) manager.find(code);
			// lecture = department.findLecture(code);
			registeredList.add(lecture);
		}
	}

	void printWithLecture() {
		System.out.format("%d %s %s (%d학년)\n", id, name, phone, year);
		System.out.println();
		for (Lecture lecture : registeredList) {
			System.out.print("\t");
			lecture.print();
		}
	}

	public void print() {
		System.out.format("%d %s %s (%d학년)\n", id, name, phone, year);
		System.out.println();

	}

	public boolean matches(String kwd) {
		if (name.contains(kwd))
			return true;
		if (kwd.equals("" + id))
			return true;
		if (phone.contains(kwd))
			return true;
		return false;
	}

	boolean containsLecture(Lecture lectureSearch) {

		for (Lecture lecture : registeredList) {
			if (lectureSearch.lectureName.equals(lecture.lectureName)) {
				return true;
			}
		}
		return false;
	}

	boolean matches(String kwds[]) {
		for (String kwd : kwds) {
			if (kwd.charAt(0) == '-' && matches(kwd.substring(1)))
				return false;
			if (!matches(kwd))
				return false;
		}
		return true;
	}

	boolean findDiffernce(Lecture lectureSearch) {
		if (this.year != lectureSearch.year)
			return true;
		return false;
	}
}
