public class MarketplaceApp {
    public static void main(String[] args) {
        InventoryManager im = new InventoryManager();
        
        Product w = new Product("V01", "Wheat (10kg)", 50, 400.0);
        im.addProduct(w);

        // Quick thread tests
        OrderProcessor t1 = new OrderProcessor(im.getProduct("V01"), 10);
        OrderProcessor t2 = new OrderProcessor(im.getProduct("V01"), 45);

        t1.start();
        t2.start();
    }
}