package manageable_Course;

import java.util.ArrayList;
import java.util.Scanner;

public class ABook extends Book {
	ArrayList<String> appendix = new ArrayList<>();
	@Override
	public void read(Scanner scan) { 
		super.read(scan);
		String tmp = null;
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			tmp = scan.next();
			appendix.add(tmp);
		}
	}
	@Override
	public void print() { 
		super.print();
		System.out.print("\t");
		for (String tmp:appendix)
			System.out.print(tmp + " ");
		System.out.println();
	}
	@Override
	public boolean matches(String kwd) { 
		if (super.matches(kwd))
			return true;
		if (kwd.contentEquals("부록책"))
			return true;
		for (String tmp:appendix)
			if (tmp.contains(kwd))
				return true;
		return false;
	}
}
