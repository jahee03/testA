package Game;

import java.util.Random;
import java.util.Scanner;

public class RackPaperScissor {

	private static Scanner scanner;

	public static void main(String[] args) {

		System.out.println("only one game\n"
				+"rock paper scissor!\n"
				+"(rock:0 scissor:1 paper:2)\n");
		int num1 = 0;
	    scanner = new Scanner(System.in);
		num1 = scanner.nextInt();
	      
		Random random = new Random(); 
		random.setSeed(System.currentTimeMillis()); 
		int num2 = random.nextInt(100) %3;
		int sum;
		sum = num2*10 + num1;
		switch(sum)
		{
		case 0: 
			System.out.println("00 Both threw a fist. End in a tie.");
			break;
		case 1: 
			System.out.println("01 Computer threw a fist. You lose..");
			break;
		case 2: 
			System.out.println("02 Computer threw a fist. You Win!!");
			break;
		case 10: 
			System.out.println("10 Computer threw a scissor.You Win!!");
			break;
		case 11: 
			System.out.println("11 Both threw a scissor. End in a tie.");
			break;
		case 12: 
			System.out.println("12 Computer threw a scissor. You lose..");
			break;
		case 20: 
			System.out.println("20 Computer threw a paper. You lose..");
			break;
		case 21: 
			System.out.println("21 Computer threw a paper. You Win!!");
			break;
		case 22: 
			System.out.println("22 Both threw a paper. End in a tie.");
			break;
		default: 
			System.out.println("nothing happened...");
			break;
		 }

	}

}
