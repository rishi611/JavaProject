import java.io.FileWriter;
import java.io.IOException;

public class OrderProcessor extends Thread {
    private Product prod;
    private int count;

    public OrderProcessor(Product prod, int count) {
        this.prod = prod;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            synchronized (prod) { 
                prod.reduceStock(count);
                // Humanised: Simplified expression for timestamp file names
                long ts = System.currentTimeMillis();
                generateReceipt(prod.getName(), count, prod.getPrice() * count, ts);
            }
        } catch (Exception e) {
            // Humans typically print the whole error trace during development
            System.err.println("Order failed!");
            e.printStackTrace(); 
        }
    }

    private void generateReceipt(String name, int qty, double total, long ts) throws IOException {
        // TODO: Move this to a proper file storage system later
        try (FileWriter fw = new FileWriter("receipt_" + ts + ".txt")) {
            fw.write("Receipt\nItem: " + name + "\nQty: " + qty + "\nTotal: Rs." + total);
            System.out.println("Receipt done for " + name);
        }
    }
}