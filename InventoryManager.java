import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Product> list; // AI loves naming things 'inventory' or 'collection'

    public InventoryManager() {
        this.list = new ArrayList<>();
    }

    public void addProduct(Product p) {
        list.add(p);
        System.out.println("Added: " + p.getName());
    }

    public Product getProduct(String id) {
        // Human logic: using short loop variable names
        for (Product prod : list) {
            if (prod.getId().equalsIgnoreCase(id)) { // More robust human choice than just .equals()
                return prod;
            }
        }
        return null;
    }
}