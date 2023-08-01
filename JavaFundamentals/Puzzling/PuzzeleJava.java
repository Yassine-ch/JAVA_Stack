import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {

    // create an array of 10 random Integers between 1 and 20
    public ArrayList<Integer> getTenRolls() {
        Random randomMachine = new Random();

        ArrayList<Integer> tenRolls = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            tenRolls.add(randomMachine.nextInt(20) + 1);
        }
        return tenRolls;
    }

    // create and array of Characters and randomly return one
    public Character getRandomLetter() {
        Random randomMachine = new Random();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(Character letter = 'a'; letter <= 'z'; letter++) {
            alphabet.add(letter);
        }

        return alphabet.get(randomMachine.nextInt(26));
    }

    // call getRandomLetter 8 times and use that to generate a random password
    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    // fill an array with randomly generated passwords from generatePassword
    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwords = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            passwords.add(generatePassword());
        }
        return passwords;
    }

    // shuffle an array of any type T
    public <T> void shuffleArray(ArrayList<T> array) {
        Random randomMachine = new Random();
        if(array.size() == 1) {
            return;
        }
        for (int i = 0; i < array.size(); i++) {
            int j = randomMachine.nextInt(i + 1);
            if (i == j) {
                continue;
            }
            T temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }
}