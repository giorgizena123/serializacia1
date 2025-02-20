import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Country[] countries = new Country[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("შეიყვანეთ ინფორმაცია " + (i + 1) + " ქვეყნის შესახებ:");
            System.out.print("დასახელება: ");
            String name = scanner.nextLine();
            System.out.print("მოსახლეობა: ");
            int population = scanner.nextInt();
            System.out.print("ფართობი: ");
            double area = scanner.nextDouble();
            scanner.nextLine();
            countries[i] = new Country(name, population, area);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("countries.txt"))) {
            oos.writeObject(countries);
            System.out.println("ინფორმაცია წარმატებით ჩაიწერა ფაილში.");
        } catch (IOException e) {
            System.err.println("შეცდომა ფაილში ჩაწერისას: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("countries.txt"))) {
            Country[] readCountries = (Country[]) ois.readObject();
            System.out.println("\nწაკითხული ინფორმაცია ქვეყნების შესახებ:");
            for (Country country : readCountries) {
                System.out.println(country);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("შეცდომა ფაილიდან წაკითხვისას: " + e.getMessage());
        }
    }
}
