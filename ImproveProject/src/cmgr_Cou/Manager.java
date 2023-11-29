package cmgr_Cou;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Manager {
	ArrayList<Calory> calList = new ArrayList<>();
	
	public void printAll() {
		for(Calory cal : calList) {
			cal.print();
			System.out.println();
		}
	}
	
	public void readAll(String filename, Factory fac) {
		Scanner filein = openFile(filename);
		Calory cal = null;
		while(filein.hasNext()) {
			cal = fac.create(filein);
			cal.read(filein);
			calList.add(cal);
		}
		filein.close();
	}
	
	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e)
		{
			System.out.println("파일 입력 오류");
			System.exit(0);
		}
		return filein;
	}
	
	public Calory find(String kwd) {
		for(Calory cal : calList) {
			if(cal.matches(kwd)) {
				return cal;
			}
		}
		return null;
	}
	
	public int getTotalCalory() {
		int total = 0;
		for(Calory cal : calList) {
			total += cal.getKcal(0,"");
		}
		return total;
	}
	public void addElement(Calory e) {
		calList.add(e);
	}
}
