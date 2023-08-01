import java.util.ArrayList;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
        //..
		// Write your other test cases here.
		//..

        // test getRandomLetter
        Character randomLetter = generator.getRandomLetter();
        System.out.println(randomLetter);

        // test generatePassword
        String randomPassword = generator.generatePassword();
        System.out.println(randomPassword);

        // test getNewPassord
        ArrayList<String> randomPasswordSet = generator.getNewPasswordSet(5);
        System.out.println(randomPasswordSet);

        // test shuffleArray with Integer
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        generator.shuffleArray(numbers);
        System.out.println(numbers);
        
        // test shuffleArray with String
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(Character letter = 'a'; letter <= 'z'; letter++) {
            alphabet.add(letter);
        }
        generator.shuffleArray(alphabet);
        System.out.println(alphabet);

	}
}