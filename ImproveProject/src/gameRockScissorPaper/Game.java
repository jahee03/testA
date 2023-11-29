package gameRockScissorPaper;

public class Game{
	public void play(int a) 
	{
		switch(a)
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

