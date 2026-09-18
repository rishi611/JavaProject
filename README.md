Hyperlocal Vendor Marketplace System

This is my semester project for Programming in Java (CSE2006) at VIT Bhopal. It's a small Java backend that simulates how a local vendor (think a neighborhood kirana store or a small wholesaler) could track inventory and handle multiple customer orders coming in at the same time, without overselling stock.

Why this project:

I noticed that a lot of small vendors, especially in smaller towns like Sehore, just track stock in a notebook or from memory. That works fine until two customers order the same thing around the same time and you end up promising more than you actually have. So the goal here was to build something simple that handles that specific problem properly: keep an inventory, take orders, and make sure stock never goes negative even if orders come in concurrently.

What it does:

Keeps a basic in-memory catalog of products (add a product, look one up by ID)
Processes each order on its own thread, so multiple customers can "order" at once
Uses a synchronized block when reducing stock so two threads can't both grab the last few units at the same time
Throws a custom InsufficientStockException if someone tries to order more than what's in stock
Writes out a simple text receipt for every order that actually goes through
Files in this repo
MarketplaceApp.java – entry point, sets up one product and fires off two test orders
Product.java – the product itself (id, name, qty, price) plus the stock-reduction logic
InventoryManager.java – holds the list of products, lets you add/find them
OrderProcessor.java – a Thread subclass, this is what actually processes an order and writes the receipt
InsufficientStockException.java – custom checked exception for out-of-stock orders
Project Report.pdf – the full write-up (problem statement, architecture, diagrams, testing, etc.)




How to run it:

You just need a JDK installed.

bash
git clone https://github.com/rishi611/JavaProject.git
cd JavaProject
javac *.java
java MarketplaceApp
What you'll see

MarketplaceApp adds 50 units of Wheat to inventory, then starts two orders at once — one for 10 units and one for 45. Since 10 + 45 is more than 50, both can't succeed. Something like this gets printed:

Added: Wheat (10kg)
Receipt done for Wheat (10kg)
Order failed!
InsufficientStockException: Out of stock: Wheat (10kg)

A receipt_<timestamp>.txt file also gets created in the project folder for whichever order went through. Since both orders start as separate threads, which one actually succeeds can change run to run — that's kind of the point, it's testing that the synchronization holds up regardless of order.



The full project report (Project Report.pdf) has more detail — requirements, architecture, use case/class diagrams, testing approach, and the challenges I ran into while building this.


BY:

Rishiraj Singh Rajput — B.Tech CSE, VIT Bhopal
