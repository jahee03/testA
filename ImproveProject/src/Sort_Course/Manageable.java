package Sort_Course;

import java.util.Scanner;

interface Manageable {
	void read(Scanner scan);

	void print();

	boolean matches(String kwd);
}
