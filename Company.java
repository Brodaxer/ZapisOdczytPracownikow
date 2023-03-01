import java.util.Scanner;

class Company {
    Scanner sc = new Scanner(System.in);
    private static final int MAX_EMPLOYEE = 3;
    private Employee[] people = new Employee[MAX_EMPLOYEE];
    private int count = 0;

    void addEmployee(Employee employe) {
        if (count < 3) {
            people[count] = employe;
            count++;
        } else {
            System.out.println("Brak wolnych miejsc");
        }
    }


}
