package cmgr_Cou;

import java.util.Scanner;
public interface Calory {
	public void read(Scanner scan);
	public int getKcal(int num , String u);
	public boolean matches(String kwd);
	public void print();
}
