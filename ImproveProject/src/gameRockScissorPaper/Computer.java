package gameRockScissorPaper;

import java.util.Random;

public class Computer {
	public int decide() 
	{
        Random random = new Random(); 
        random.setSeed(System.currentTimeMillis());
        int num2 = random.nextInt(100) %3;
        return num2;
	}
}
