import java.io.*;
import java.util.Scanner;

class CompanyControler {
    Scanner sc = new Scanner(System.in);
    void run(Company company) {
        int i;
        do {
            System.out.println("""
                    Wybierz opcje 
                    1 - Dodaj pracowanika
                    2 - Pokaz info o pracownikach
                    3 - Zapisz do pliku dodanych pracowikow
                    4 - Wczytaj z pliku pracownikow
                    5 - Zakoncz dzialanie
                    """);
            i = sc.nextInt();
            switch (i) {
                case 1 -> loadDataFromUser(company);
                case 2 -> printEmployee(company);
                case 3 -> saveToFile(company);
                case 4 -> readFromFile(company);
                case 5 -> System.out.println("Bye");
            }
        } while (i != 5);

    }

    public void loadDataFromUser(Company company) {
        Employee employee = crateEmploye();
        company.addEmployee(employee);
    }
    private Employee crateEmploye(){
        sc.nextLine();
        System.out.println("Podaj imię:");
        String firstName = sc.nextLine();
        System.out.println("Podaj nazwisko:");
        String lastName = sc.nextLine();
        System.out.println("Podaj wynagrodzenie:");
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
    public void readFromFile(Company company){
        String fileName = "company.obj";
        try (
                var fis = new FileInputStream(fileName);
                var ois = new ObjectInputStream(fis);
                ){
            company = (Company) ois.readObject();
        }catch (ClassNotFoundException | IOException e){
            System.err.println("Nie udalo sie odczytac z pliku");
            e.printStackTrace();
        }

    }
}

