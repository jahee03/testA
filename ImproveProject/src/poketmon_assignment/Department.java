package poketmon_assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Poketmon> poketmonList = new ArrayList<>();		
	void run() 
	{
		int choice = 0;
		while (choice >=0)
			{
			switch (choice){
			case 0:
				System.out.println("0.메뉴 1.입력 2.검색 3.끝내기");
				choice = scan.nextInt();
				break;
			case 1:
				System.out.println("정보를 입력하세요");
				readAll();
				printAll();
				choice = 0;
				break;
			case 2:
				search();
				choice = 0;
				break;
			default:
				break;
			}
		
		}
	}

	void readAll() 
	{
		Poketmon poketmon = null;
		for (int i = 0; i < 5; i++) {
			poketmon = new Poketmon();
			poketmon.read(scan);
			poketmonList.add(poketmon);
		}
	}
	void printAll() 
	{
		for (Poketmon poketmon : poketmonList) {
		poketmon.print();
		}
	}
	void search() {
		String kwd = null;
		while (true) {
			System.out.println("검색을 끝내려면 end를 입력하세요. 검색:");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (Poketmon poketmon : poketmonList) {
				if (poketmon.matches(kwd))
					poketmon.print();
			}
		}	
	}
	
	public static void main(String args[]) {
		Department department = new Department();
		department.run();
	}

}
