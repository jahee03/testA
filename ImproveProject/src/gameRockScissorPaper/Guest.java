package gameRockScissorPaper;

import java.util.Scanner;

public class Guest {
	private Scanner scanner;
	public int getNumber() 
	{
		int num1 = 0;
		scanner = new Scanner(System.in);
		num1 = scanner.nextInt();
		return num1;
	}
}