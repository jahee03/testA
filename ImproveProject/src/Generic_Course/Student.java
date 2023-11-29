package Generic_Course;

import java.util.ArrayList;
import java.util.Scanner;

class Student implements Manageable {
	String name;
	String id;
	String phone;
	int year;
	ArrayList<Lecture> registeredList = new ArrayList<>();

//	Student(String id2) {
//		this.id = id2;
//	}

	public void read(Scanner scan) {
		id = scan.next();
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
		String code;
		Lecture lecture = null;
		while (true) {
			code = scan.next();
			if (code.equals("0"))
				break;
			lecture = Department.lecMgr.find(code);
			// lecture = department.findLecture(code);
			registeredList.add(lecture);
		}
	}

	public void print(boolean b) {
		System.out.format("%s %s %s (%d학년)\n", id, name, phone, year);
		if (b)
			return;
		for (Lecture lecture : registeredList) {
			System.out.print("\t");
			lecture.print();
		}
		System.out.println();
	}

	public void print() {
		print(false);
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
//
//	boolean containsLecture(Lecture lectureSearch) {
//		for (Lecture lecture : registeredList) {
//			if (lectureSearch.lectureName.equals(lecture.lectureName)) {
//				return true;
//			}
//		}
//		return false;
//	}

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
