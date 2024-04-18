package homeworks.hw1.scooter;

import java.util.Scanner;

/**
 * A class to test the scooter rental system by renting a scooter,
 * and returning it.
 */
public class ScooterRentalTester {

    public static void main(String[] args) {
        RentalCompany rentalCompany = new RentalCompany();
        Scanner scanner = new Scanner(System.in);
        // Displays the choses for the user.
        while (true) {
            System.out.println("1. Add Scooter");
            System.out.println("2. Rent Scooter");
            System.out.println("3. Return Scooter");
            System.out.println("4. Display All Scooters");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter model name for the scooter:");
                    String modelName = scanner.next();
                    rentalCompany.addScooter(new Scooter(modelName));
                    break;
                case 2:
                    System.out.println("Enter scooter ID to rent:");
                    int idToRent = scanner.nextInt();
                    rentalCompany.rentScooter(idToRent);
                    break;
                case 3:
                    System.out.println("Enter scooter ID to return:");
                    int idToReturn = scanner.nextInt();
                    rentalCompany.returnScooter(idToReturn);
                    break;
                case 4:
                    rentalCompany.displayAllScooters();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }
}
