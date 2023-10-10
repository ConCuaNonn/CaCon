import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Prototype{
    Warehouse warehouse;
    Employee employee;
    Catalog catalog;


    public Manager(){
        this.warehouse = new Warehouse();
        this.employee = new Employee();
        this.catalog = new Catalog();
    }

    @Override
    public void displayMenu() {
        System.out.println("Supermarket Manager Menu:");
        System.out.println("1. Track Inventory");
        System.out.println("2. Buy Products");
        System.out.println("3. Manage Inventory");
        System.out.println("4. Sell Products");
        System.out.println("5. Pay Employees");
        System.out.println("6. Display Catalog");
        System.out.println("0. Exit");
    }

    public void displayTime() {
            // Get the current date and time
            LocalDateTime currentTime = LocalDateTime.now();

            // Define a format for displaying the time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Format and display the current time
            String formattedTime = currentTime.format(formatter);
            System.out.println("Current Time: " + formattedTime);

    }

    @Override
    public void trackInventory() {
        warehouse.trackInventory();
    }

    @Override
    public void buyInventory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("your options are: milk,rice,apple,date,bread,meat(or any other thing)");
        System.out.print("Enter the name of the product to buy: ");
        String product = scanner.next();

        System.out.print("Enter quantity to buy: ");
        int quantity = scanner.nextInt();

        System.out.println("Enter price of " + product + ":");
        double cost = scanner.nextDouble();

        double itemCost = catalog.recordItemPurchase(product,quantity,cost);

        double total = itemCost * quantity;

        System.out.println("your purchased: " + total);

        warehouse.buyInventory(product,quantity);

        double preCost = catalog.getCostOfItemsPurchased();
        catalog.setCostOfItemsPurchased(preCost + total);
    }

    @Override
    public void manageInventory() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product to manage: ");
        String product = scanner.next();

        System.out.print("Enter quantity to manage: ");
        int quantity = scanner.nextInt();

        warehouse.manageInventory(product,quantity);
    }

    @Override
    public void sellInventory() {
        double totalEarnings = 0;
        String productName;


        Scanner scanner = new Scanner(System.in);
        List<String> products = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        List<Double> revenues = new ArrayList<>();

        boolean run = true;

        while (run) {

            System.out.println("\nWhich items would you like to sell (separated by commas and type (,done) one u finish)?\n");
            Scanner reader = new Scanner(System.in);
            String itemNames = reader.nextLine(); // Allow multiple items to be entered, separated by commas
            String[] itemsToSell = itemNames.split(",");
            if (itemsToSell.equals("done")) {
                break; // Exit the loop if 'done' is entered

            }

            for (int i = 0; i < itemsToSell.length - 1; i++) {
                itemsToSell[i] = itemsToSell[i].trim();
                productName = itemsToSell[i];

                System.out.print("Enter quantity to sell of" + productName +": ");
                int quantity = scanner.nextInt();

                System.out.print("Enter revenue of " + productName + ": ");
                double revenue = scanner.nextDouble();

                products.add(productName);
                quantities.add(quantity);
                revenues.add(revenue);

            } run = false;


        }


        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            int quantity = quantities.get(i);
            double revenue = revenues.get(i);

            double itemRevenue = catalog.recordItemSale(product, quantity, revenue);
            double total = quantity * revenue;
            totalEarnings += total;

            System.out.println("You've earned " + total + " for " + quantity + " " + product);
            warehouse.sellInventory(product, quantity);
            catalog.setTotalSales(total);
        }

        System.out.println("Total earnings: " + totalEarnings);
    }

    @Override
    public void payEmployees() {
        employee.addEmployee("Duy",800);
        employee.addEmployee("Christian",800);
        employee.addEmployee("Kien",800);
        employee.addEmployee("Dornaz",200);
        employee.payEmployees();
    }

    public void displayCatalog(){
        employee.catalog.displayCatalog();
    }
}
