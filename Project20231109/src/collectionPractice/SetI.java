package collectionPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetI {
	Random rand =new Random();
	Set<Integer> randSet = new HashSet<>();
	Collection<Integer> c = new ArrayList<>();
	int n = 0;
	{
		for (int i = 0; i < 30; i++) {
			n = rand.nextInt(30);
			randSet.add(n);
			c.add(i);
		}
		System.out.println("난수집합: " + randSet);
		c.removeAll(randSet); // 벌크 연산
		System.out.println("제외집합: " + c);

		
	}
}