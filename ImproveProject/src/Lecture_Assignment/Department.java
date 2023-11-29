package Lecture_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Lecture> lectureList = new ArrayList<>();
	int state = 0;
	int stateSub = 0;
	Student st;

	void run() {
		while (state <= 3) {
			switch (state) {
			case 0:
				System.out.print("메뉴 선택 \n1.과목 2.학생 3.연관검색 ");
				System.out.print("4.나가기\n");
				state = scan.nextInt();
				break;
			case 1:
				readAllLecture();
				state = 0;
				break;
			case 2:
				readAllStudent();
				state = 0;
				break;
			case 3:
				while (stateSub <= 3) {
					switch (stateSub) {
					case 0:
						System.out.print("연관검색 메뉴\n1.과목별 수강생 " + "2.요일별 수강생 3.타학년 과목 수강생 수 조사 4.이전 메뉴 돌아가기\n");
						stateSub = scan.nextInt();
						break;
					case 1:
						searchStudentsByLecture();
						stateSub = 0;
						break;
					case 2:
						searchStudentsByDay();
						stateSub = 0;
						break;
					case 3:
						searchByDifferentYear();
						stateSub = 0;
						break;
					default:
						break;
					}
				}
				state = 0;
				break;
			default:
				break;
			}
		}
	}

	void readAllLecture() {
		System.out.print("[과목입력]\n");
		System.out.print("종료 시 end 입력\n");
		Lecture lecture = null;
		String code = null;
		while (true) {
			code = scan.next();
			if (code.equals("end"))
				break;
			lecture = new Lecture(code);
			lecture.read(scan, this);
			lectureList.add(lecture);
		}
	}

	void readAllStudent() {
		System.out.print("[학생입력]\n");
		System.out.print("종료 시 0입력\n");
		Student st = null;
		int studentId;
		while (true) {
			studentId = scan.nextInt();
			if (("" + studentId).equals("0"))
				break;
			st = new Student(studentId);
			st.read(scan, this);
			studentList.add(st);
		}
	}

	void printAllStudent() {
		System.out.print("[명단 출력]\n");
		for (Student st : studentList) {
			st.print();
		}
	}

	void searchMulti() {
		String kwd = null;
		String[] kwds = null;
		while (true) {
			System.out.print("검색:(키워드 여러 개일 경우 빈칸으로 구분):");
			kwd = scan.nextLine();
			kwds = kwd.split(" ");
			if (kwd.equals("end"))
				break;
			for (Student st : studentList) {
				if (st.matches(kwds))
					st.print();
			}
		}
	}

	void searchLecture() {
		String kwd = null;
		while (true) {
			System.out.print("검색:(키워드 여러 개일 경우 빈칸으로 구분):");
			kwd = scan.nextLine();
			if (kwd.equals("end"))
				break;
			for (Lecture lecture : lectureList) {
				if (lecture.matches(kwd))
					lecture.print();
			}
		}
	}

	void searchStudentsByLecture() {
		String kwd;
		System.out.print("검색할 과목: ");
		kwd = scan.next();
		Lecture lectureSearch = findLecture(kwd);
		lectureSearch.print();
		for (Student st : studentList) {
			if (st.containsLecture(lectureSearch))
				st.print();
		}
	}

	void searchStudentsByDay() {
		String kwds;
		System.out.print(">>검색할 요일: ");
		kwds = scan.next();
		System.out.printf("\n%s요일 과목을 수강하는 학생: ", kwds);
		for (Lecture lecture : lectureList) {
			if (lecture.day.contains(kwds)) {
				System.out.println();
				lecture.print();
				for (Student st : studentList) {
					if (st.containsLecture(lecture)) {
						System.out.printf("%s ", st.name);
					}
				}
			}
		}
	}

	void searchByDifferentYear() {
		int sum = 0;
		String kwd;
		System.out.print("검색할 과목: ");
		kwd = scan.next();
		Lecture lectureSearch = findLecture(kwd);
		if (lectureSearch == null) {
			System.out.println("없는 과목명입니다");
			return;
		}
		lectureSearch.print();
		for (Student st : studentList) {
			if (st.containsLecture(lectureSearch)) {
				if (st.findDiffernce(lectureSearch))
					sum++;
			}
		}
		System.out.printf("%d명", sum);
		System.out.println();
	}

	Lecture findLecture(String code) {
		Lecture lectureSearch = null;
		for (Lecture lecture : lectureList)
			if (lecture.matches(code))
				lectureSearch = lecture;
		return lectureSearch;
	}

	public static void main(String args[]) {
		Department department = new Department();
		department.run();
	}

}
