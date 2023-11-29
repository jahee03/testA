package Manager_Course;

import java.util.Scanner;

interface Manageable {
	void read(Scanner scan, Manager manager);

	void print();

	boolean matches(String kwd);

}
