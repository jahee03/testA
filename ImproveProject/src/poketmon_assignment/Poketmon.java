package poketmon_assignment;

import java.util.Scanner;

public class Poketmon {
	int number = 0;
	String name;
	int attack;
	int depence;
	int HP;
	String type;
	
	void read(Scanner scan) 
	{		
		number = scan.nextInt();
		name = scan.next();
		attack = scan.nextInt();	
		depence = scan.nextInt();
		HP = scan.nextInt();
		type = scan.next();
	}

	void print() 
	{
		System.out.format("%d %s %d %d %d %s\n",
				number, name, attack, depence, HP, type);
		
	}

	boolean matches(String kwd) {
		if (name.contains(kwd))
			return true;
		if (kwd.equals("" + number))
			return true;
		if (type.contains(kwd))
			return true;
		return false;
	}
}