import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Scanner scanner = new Scanner(System.in);


        int choice;
        do {
            manager.displayTime();
            manager.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.trackInventory();
                    break;
                case 2:
                    manager.buyInventory();
                    break;
                case 3:
                    manager.manageInventory();
                    break;
                case 4:
                    manager.sellInventory();
                    break;
                case 5:
                    manager.payEmployees();
                    break;
                case 6:
                    manager.displayCatalog();
                case 0:
                    System.out.println("Exiting the Supermarket Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        Catalog catalog = new Catalog();

        scanner.close();
    }
}