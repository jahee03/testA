package calory_Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Dines {
	ArrayList<Dine> dineList = new ArrayList<>();

	ArrayList<Food> foods = new ArrayList<>();
	HashMap<String, Food> foodMap = new HashMap<>();

	public static void main(String[] args) {
		Dines main = new Dines();
		main.run();
	}


	void readAllDine(String filename) {
		Scanner filein = openFile(filename);
		while (filein.hasNext()) {
			Dine dine = null;
			int month = filein.nextInt();
			dine = new Dine(month);
			if (month == 0)
				break;
			dineList.add(dine);
		}
		filein.close();
	}

	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("파일 입력 오류");
			System.exit(0);
		}
		return filein;
	}

	void readFoods(String filename) {
		Scanner filein = openFile(filename);
		Food m = null;
		int serialNo = 0;
		while (filein.hasNext()) {
			serialNo = filein.nextInt();
			if (serialNo == 0)
				break;
			m = new Food(serialNo);
			m.read(filein);
			foods.add(m);
			foodMap.put(m.name, m);
			// System.out.println(m);
		}
		filein.close();
	}

	void printDine() {
		for (Dine dine : dineList)
			dine.printEats();

	}

	void printFoods() {
		for (Food f : foods) {
			System.out.println(f);
		}
	}

	Food findFood(String n) {
		Food f = foodMap.get(n);
		if (f == null) {
			System.out.println("find null => " + n);
			throw new NullPointerException();
		}
		return f;
	}

	private void run() {
		readFoods("food.txt");
		printFoods();
		readAllDine("eats-input.txt");
		printDine();
	}
}
