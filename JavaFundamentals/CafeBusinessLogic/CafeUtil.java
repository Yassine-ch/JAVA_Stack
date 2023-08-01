import java.util.ArrayList;
public class CafeUtil {

    // getStreakGoal method that sums up to 10 by default
    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    // overload method to take in a number of weeks
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println(String.format("Hello, %s! There are %o people in front of you", userName, customers.size()));
        customers.add(userName);
        System.out.println(customers);
    }

    // print a number of products and its prices
    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.println(i + String.format(" - $%.2f", (price * i)));
        }
    }

    // print a number of products and its prices but with a $0.50 discount on every extra one
    public void printPriceDiscountChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double discount = (i - 1) * 0.5;
            System.out.println(i + String.format(" - $%.2f", (price * i - discount)));
        }
    }

    // print the menu with prices
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i) + String.format(" -- $%.2f", prices.get(i)));
        }
        return true;
    }
}