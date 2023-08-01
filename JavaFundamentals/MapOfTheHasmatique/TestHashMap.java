import java.util.HashMap;
import java.util.Set;
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, String> tracklist = new HashMap<>();

        // add 4 key value pairs
        tracklist.put("Song 1", "these are the lyrics");
        tracklist.put("Song 2", "more lyrics");
        tracklist.put("Song 3", "blaaaaa");
        tracklist.put("Song 4", "mooooo");

        System.out.println(tracklist.get("Song 3"));

        // loop through the keys of the HashMap
        Set<String> keys = tracklist.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + tracklist.get(key));
        }
    }
}