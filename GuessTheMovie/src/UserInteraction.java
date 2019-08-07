import java.util.ArrayList;

public class UserInteraction {
    static final String PROMPT1 = "You are guessing:";
    static final String PROMPT2a = "You have guessed (";
    static final String PROMPT2b = ") wrong letters:";
    static final String PROMPT3 = "Guess a letter:";
    private boolean start = true;

    public void prompt(char[] guess, ArrayList guessedLetters) {
        System.out.print(PROMPT1);
        System.out.println(guess);
        System.out.print(PROMPT2a);
        System.out.print(getGuessedLetters(guessedLetters));
        System.out.println(PROMPT2b);
        System.out.print(PROMPT3);
    }

    public void win(String answer) {
        System.out.println("You win!");
        System.out.print("You have guessed");
        System.out.print(" '" + answer + "' ");
        System.out.print("correctly.");
    }

    public void lose() {
        System.out.println("You lose, already used 10 chances!");
    }


//    private void checkInput(String guess) {
//        String sanitizedGuess = sanitizeInput(guess);
//        if(sanitizedGuess != null){
//
//        }
//        else{
//            System.out.println("Please enter correct input. Try Again!");
//            continue;
//        }
//    }

    private int getGuessedLetters(ArrayList guessedLetters) {
        return guessedLetters.size();
    }

    public char sanitizeInput(String guess) {
        guess = guess.trim();
        Character myChar = guess.charAt(0);
        if (guess.length() == 1 && (Character.isDigit(myChar) || Character.isLetter(myChar))) {
            return guess.charAt(0);
        }
        return Character.MIN_VALUE;
    }
}
