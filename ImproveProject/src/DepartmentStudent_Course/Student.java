package DepartmentStudent_Course;

import java.util.Scanner;

class Student {
	String name;
	int id;
	String phone;
	int year;
	void  read(Scanner scan) {
		id = scan.nextInt();
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
	}
	void print() {
		System.out.format("%d %s %s (%d학년)\n",
				id,name,phone,year);
	}
	boolean matches(String kwd) {
		if (kwd.equals(name))
			return true;
		if (kwd.equals("" + id))
			return true;
		if (kwd.equals(phone))
			return true;
		return false;
	}
		
}