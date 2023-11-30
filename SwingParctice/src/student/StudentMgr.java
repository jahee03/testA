package student;

import java.util.List;
import mgr.Factory;
import mgr.Manager;
import song_label.GUIMain;

public class StudentMgr extends Manager<Student> {
	public StudentMgr() {
		readAllStudents("Student.txt");
	}
	//Scanner scan = new Scanner(System.in);
	void readAllStudents(String filename) {
		super.readAll(filename, new Factory<Student>() {
			public Student create() {
				return new Student();
			}
		});
	}
	public List<Student> search(String kwd) {
		if (kwd == null)
			return mList;
		return findAll(kwd);
	}
	public void update(int n, String title) {
		// TODO Auto-generated method stub
		Student s = find(""+n);
		s.set(title);
	}
	public void removeAt(int num) {
		// TODO Auto-generated method stub
		Student s = find(""+num);
		mList.remove(s);
	}
	public static void main(String[] args) {
		StudentMgr engine = new StudentMgr();
		GUIMain.startGUI(engine);
	}
}
