import java.util.Scanner;

class CompanyApp {
    Scanner sc = new Scanner(System.in);

    public void loadDataFromUser(Company company) {
        System.out.println("Podaj nowego pracownika:");
        Employee employee = crateEmploye();
        company.addEmployee(employee);
    }

    private Employee crateEmploye(){
        System.out.println("Podaj imię:");
        String firstName = sc.nextLine();
        System.out.println("Podaj nazwisko:");
        String lastName = sc.nextLine();
        System.out.println("Podaj wynagrodzenie:");
        sc.nextLine();
        double wage = sc.nextDouble();
        return new Employee(firstName,lastName,wage);
    }
}
