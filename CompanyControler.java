import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

class CompanyControler {
    Scanner sc = new Scanner(System.in);
    void run(Company company){
        System.out.println("""
                Wybierz opcje 
                1 - Dodaj pracowanika
                2 - Pokaz info o pracownikach
                3 - Zapisz do pliku dodanych pracowikow
                4 - Zakoncz dzialanie
                """);
        do {
            switch (sc.nextInt()){
                case 1 -> loadDataFromUser(company);
                case 2 -> printEmployee(company);
                case 3 -> saveToFile(company);
                case 4-> System.out.println("Bye");
            }
        } while (sc.nextInt()==4);

    }

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
    public void printEmployee(Company company){
        System.out.println(company.toString());
    }
    public void saveToFile(Company company){
        String fileName = "company.obj";
        try (
                var fs = new FileOutputStream(fileName);
                var os = new ObjectOutputStream(fs);
                ){
            os.writeObject(company);
            System.out.println("Zapisano obiekt do pliku");
        }catch (IOException e){
            System.err.println("Blad zapisu pliku "+ fileName);
            e.printStackTrace();
        }
    }
}
