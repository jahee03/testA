package student;

import java.util.Scanner;

import mgr.Manageable;

public class Student implements Manageable {
    String name;
    int id;
    String phone;
    int year;

    public void read(Scanner scan) {
        id = scan.nextInt();
        name = scan.next();
        phone = scan.next();
        year = scan.nextInt();
    }

    public void print() { // Student
        System.out.format("%d %s %s (%d학년)\n", id, name, phone, year);
    }

    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        if (kwd.length() == 0)
            return true;
        if (kwd.length() == 1 && kwd.equals("" + year))
            return true;
        if (kwd.length() >= 4 && phone.contains(kwd))
            return true;
        if (kwd.length() >= 4 && ("" + id).contains(kwd))
            return true;
        return name.contains(kwd);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s (%d학년)", id, name, phone, year);
    }

    public void set(Object[] row) {
        id = Integer.parseInt((String) row[0]);
        name = (String) row[1];
        phone = (String) row[2];
        year = Integer.parseInt((String) row[3]);
    }

    public String[] getUiTexts() {
        return new String[] {"" + id, name, phone, "" + year};
    }

    public void set(String name) {
        name = this.name;
    }
}
