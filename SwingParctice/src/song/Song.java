package song;

import java.util.Scanner;
import mgr.Manageable;

public class Song implements Manageable {
	// 1 빅뱅 뱅뱅뱅 2015
	int id;
	String name;
	String title;
	int year;
	String lyric="";
	public void set(String title) {
		this.title = title;
	}
	public void set(Object[] row) {
		id = Integer.parseInt((String)row[0]);
		name = (String)row[1];
		title = (String)row[2];
		year = Integer.parseInt((String)row[3]);
	}
	@Override
	public void read(Scanner scan) {
		id = scan.nextInt();
		name = scan.next();
		title = scan.next();
		year = scan.nextInt();
	}
	@Override
	public void print() {
		System.out.printf("[%2d] %s %s (%d년)\n",
				id, name, title, year);
	}
	@Override
	public boolean matches(String n) {
		if ((""+id).equals(n))
			return true;
		if (title.contains(n))
			return true;
		return name.contains(n);
		
	}
	@Override
	public String toString() {
		return String.format("[%d] %s - %s (%d년)", id, title, name, year);
	}
	public String[] getUiTexts() {
		return new String[] {""+id, name, title, ""+year, lyric};
	}
}