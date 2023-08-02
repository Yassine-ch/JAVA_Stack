public class Item {
    
    // create Item class member variables
    private String name;
    private double price;

    // Constructor
    //   Takes a name and price as arguments and sets them accordingly
    public Item() {

    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters for name and price
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}