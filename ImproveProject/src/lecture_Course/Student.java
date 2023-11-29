package lecture_Course;

import java.util.Scanner;

import Team_Course.Department;

class Student {
	int id;
	String name;
	//String phone;
	int year;
	//Team myTeam;
	//ArrayList<Lecture> registeredList = new ArrayList<>();

	//void setTeam(Team t) {}
	void  read(Scanner scan, Department department) {
		id = scan.nextInt();
		name = scan.next();
		//phone = scan.next();
		year = scan.nextInt();
		String code;
		//Lecture lecture = null;
		while(true) {
			code = scan.next();
			if(code.equals("0"))
				break;
			//lecture = department.findLecture(code);
			//registeredList.add(lecture);
			
		}
	}
	void print() {
		System.out.format("%d %s (%d학년)\n",
				id,name,year);
	}
	boolean matches(String kwd) {
		if (kwd.equals(name))
			return true;
		if (kwd.equals("" + id))
			return true;
		//if (kwd.equals(phone))
		//	return true;
		return false;
	}
		
}