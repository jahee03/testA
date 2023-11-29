package Sort_Course;

import java.util.Collections;
import java.util.Comparator;

class Department {
	static Manager<Student> stMgr = new Manager<>();
	static Manager<Lecture> lec = new Manager<>();

	public static void main(String args[]) {
		Department main = new Department();
		main.run();
	}
	void run() {
		lec.readAll("lecture.txt", new Factory<Lecture>() {
			public Lecture create() {
				return new Lecture();
			}
		});
		lec.printAll();
		Collections.sort(lec.mList, new Comparator<Lecture>() {
			public int compare(Lecture st1, Lecture st2) {
				int result = st1.code.compareTo(st2.code);
				if(result!=0)return result;
				return (st1.lectureName.compareTo(st2.lectureName));
			}
		});
		stMgr.readAll("student.txt", new Factory<Student>() {
			public Student create() {
				return new Student();
			}
		});
//		stMgr.readAll("student.txt", new StudentFac());
//		stMgr.readAll("student.txt", Student::new);
		stMgr.printAll();
		
	}
}
