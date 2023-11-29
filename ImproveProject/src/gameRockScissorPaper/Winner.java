package gameRockScissorPaper;

public class Winner 
{
	private static int a;
	private static int b;
	public static void main(String[] args) {
		Computer computer = new Computer();
		Guest guest = new Guest();
		Game game = new Game();
		System.out.println("only one game\n"
				+"rock paper scissor!\n"
				+"(rock:0 scissor:1 paper:2)\n");
		
		a = computer.decide();
		b = guest.getNumber();
		int sum = 0;
		sum = a *10 + b;
		game.play(sum);
	}
}