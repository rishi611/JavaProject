public class Product {
    private String id;
    private String name;
    private int qty; // Humanised: shortened 'quantity' to 'qty'
    private double price;

    public Product(String id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQty() { return qty; }
    public double getPrice() { return price; }

    public void reduceStock(int amt) throws InsufficientStockException {
        if (amt > qty) {
            throw new InsufficientStockException("Out of stock: " + name);
        }
        this.qty -= amt;
    }
}