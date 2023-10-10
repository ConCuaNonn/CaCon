import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Warehouse {
    private Map<String, Integer> products;
    private Catalog catalog;

    public Warehouse(){
        this.products = new HashMap<>();
        this.catalog = new Catalog();
    }

    public void trackInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void buyInventory(String product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
        System.out.println("Added " + quantity + " " + product + " to warehouse");
    }

    public void manageInventory(String product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            if (currentQuantity >= quantity) {
                products.put(product, currentQuantity - quantity);
                System.out.println("Removed " + quantity + " " + product + " from warehouse");
            } else {
                System.out.println("Not enough " + product + " in stock.");
            }
        } else {
            System.out.println(product + " not found in warehouse.");
        }
    }
    public void sellInventory(String product, int quantity) {
        manageInventory(product, quantity);
        System.out.println("Sold " + quantity + " " + product);
    }
}
