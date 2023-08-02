import java.util.ArrayList;

// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items = new ArrayList<Item>(); // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "guest";
        this.ready = false;
    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        this.ready = false;
    }

    // ORDER METHODS

    public void addItem(Item item) {
        this.items.add(item);
    }
        // Most of your code will go here, 
        // so implement the getters and setters first!

    // GETTERS & SETTERS
    public String getName(){
    return this.name;
    }

    public boolean getReady(){
        return this.ready;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    public String getStatusMessage() {
        if(this.ready == true) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    
    public double getOrderTotal(){
        double total = 0.0;
        for(Item i: this.items) {
        total += i.getPrice();
        }
        return total;
    }
    
    public void display() {
        System.out.printf("Customer Name: %s", this.name);
        for(Item i: this.items) {
            System.out.println(i.getName() + " -$" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }
    

}