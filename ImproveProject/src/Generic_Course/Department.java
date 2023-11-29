package Generic_Course;

class Department {
	static Manager<Student> stMgr = new Manager<>();
	static Manager<Lecture> lecMgr = new Manager<>();

	public static void main(String args[]) {
		Department main = new Department();
		main.run();
	}

	void run() {
		lecMgr.readAll("lecture.txt", new Factory<Lecture>() {
			public Lecture create() {
				return new Lecture();
			}
		});
		lecMgr.printAll();
		stMgr.readAll("student.txt", new Factory<Student>() {
			public Student create() {
				return new Student();
			}
		});
//		stMgr.readAll("student.txt", new StudentFac());
//		stMgr.readAll("student.txt", () -> new Student());
//		stMgr.readAll("student.txt", Student::new);
		stMgr.printAll();
	}
}
