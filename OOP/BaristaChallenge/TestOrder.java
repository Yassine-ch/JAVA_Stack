public class TestOrder {
    public static void main(String[] args) {
        
        // create 4 items
        Item item1 = new Item("mocha", 3.5);
        Item item2 = new Item("latte", 5.5);
        Item item3 = new Item("drip coffee", 3.0);
        Item item4 = new Item("capuccino", 4.0);

        // create 2 orders for unspecified guests
        Order order1 = new Order();
        Order order2 = new Order();

        // create 3 orders with names
        Order order3 = new Order("Tom");
        Order order4 = new Order("Sam");
        Order order5 = new Order("Kate");

        // add 2 items to each order
        order1.addItem(item4);
        order1.addItem(item2);

        order2.addItem(item3);
        order2.addItem(item1);

        order3.addItem(item4);
        order3.addItem(item2);

        order4.addItem(item2);
        order4.addItem(item3);

        order5.addItem(item3);
        order5.addItem(item3);
    
        // test getStatusMessage
        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        // test getOrderTotal
        System.out.println(order1.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

    }
}
