import java.util.Date;
import java.text.SimpleDateFormat;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, %s. Lovely to see you.", name);
    }

    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }

    public String guestGreeting() {
        
        // create an instance of the Date class
        Date currentDate = new Date();

        // format the Date object based off the current hour
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        int currentHour = Integer.parseInt(formatter.format(currentDate));

        // set dayPeriod based off the current hour integer
        String dayPeriod;
        if (currentHour < 12) {
            dayPeriod = "morning";
        } else if (currentHour >= 12 && currentHour < 18) {
            dayPeriod = "afternoon";
        } else {
            dayPeriod = "evening";
        }
        
        return String.format("Good %s. Lovely to see you.", dayPeriod);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date currentDate = new Date();
        return "It is currently " + currentDate;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE

        // logic to check if conversation has Alexis or Alfred
        if (conversation.indexOf("Alexis") >= 0) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if( conversation.indexOf("Alfred") >= 0) {
            return "At your service. As you wish, naturally.";
        }

        // return this string when neither Alexis or Alfred are present
        return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}