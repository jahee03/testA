package Manager_Course;

class Department extends Manager {
	static Manager stMgr = new Manager();
	static Manager lec = new Manager();

	public static void main(String args[]) {
		Department main = new Department();
		main.run();
	}

	void run() {

		stMgr.readAll("student.txt", new Factory() {
			public Manageable creat() {
				return new Student();
			}
		});
		stMgr.printAll();
		lec.readAll("student.txt", new Factory() {
			public Manageable creat() {
				return new Student();
			}
		});
		lec.printAll();
		search();
	}
}
