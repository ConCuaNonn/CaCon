import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
public class Catalog {
    private LocalDateTime startTime;
    private int itemsBought;
    private int itemsSold;
    private double costOfItemsPurchased;
    private double costOfAmountPaidToEmployees;
    private double totalExpenses;
    private double totalSales;
    private Map<String, Integer> itemsSoldByType;
    private Map<String, Integer> itemsBoughtByType;

    public Catalog() {
        this.startTime = LocalDateTime.now();
        this.itemsBought = 0;
        this.itemsSold = 0;
        this.costOfItemsPurchased = 0;
        this.costOfAmountPaidToEmployees = 0;
        this.totalExpenses = 0;
        this.totalSales = 0;
        this.itemsSoldByType = new HashMap<>();
        this.itemsBoughtByType = new HashMap<>();
    }

    double getCostOfItemsPurchased(){
        return  costOfItemsPurchased;
    }

    void setCostOfItemsPurchased(double costOfItemsPurchased){
        this.costOfItemsPurchased = costOfItemsPurchased;
    }

    double getTotalExpenses(){
        return  totalExpenses;
    }

    void setTotalExpenses(double totalExpenses){
        this.totalExpenses = totalExpenses;
    }

    double getTotalSales(){
        return  totalSales;
    }

    void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }

    LocalDateTime getStartTime(){
        return  startTime;
    }

    void setTotalSales(double totalSales){
        this.totalSales = totalSales;
    }
        // Record an item purchase
        public double recordItemPurchase(String itemType, int quantity ,double cost) {
            itemsBought += quantity;
            /*costOfItemsPurchased = cost;*/


            itemsBoughtByType.put(itemType, itemsBoughtByType.getOrDefault(itemType, 0) + quantity);

            return cost;
        }

        // Record an item sale
        public double recordItemSale(String itemType, int quantity, double revenue) {
            itemsSold += quantity;
            totalSales += revenue;

            itemsSoldByType.put(itemType, itemsSoldByType.getOrDefault(itemType, 0) + quantity);
            return revenue;
        }

        // Record employee payment
        public void  recordEmployeePayment(double amountPaidToEmployee) {
            costOfAmountPaidToEmployees =+ amountPaidToEmployee;
            /*totalExpenses += amountPaidToEmployee;*/
            /*return amountPaidToEmployee;*/
        }

        // Display catalog information
        public void displayCatalog() {
            totalExpenses = costOfItemsPurchased + costOfAmountPaidToEmployees;
            System.out.println("Catalog Information:");
            System.out.println("Current Time: " + startTime);
            System.out.println("Items Bought: " + itemsBought);
            System.out.println("Items Sold: " + itemsSold);
            System.out.println("Cost of Items Purchased: $" + costOfItemsPurchased);
            System.out.println("Cost of Amount Paid to Employees: $" + costOfAmountPaidToEmployees);
            System.out.println("Total Expenses: $" + totalExpenses);
            System.out.println("Total Sales: $" + totalSales);
            System.out.println("Total Profit: $" + (totalSales - totalExpenses));
        }

        // Display information for a specific item type
        public void displayItemTypeInformation(String itemType) {
            System.out.println("Item Type Information for " + itemType + ":");
            System.out.println("Number of " + itemType + " Sold: " + itemsSoldByType.getOrDefault(itemType, 0));
            System.out.println("Number of " + itemType + " Bought: " + itemsBoughtByType.getOrDefault(itemType, 0));
    }
}
