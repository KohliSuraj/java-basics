import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {

        int randomNumber = (int) (Math.random() * 100) + 1;
        System.out.println("I have generated a number between 1 and 100");
        System.out.println("Let's start guessing...");

        Scanner sc = new Scanner(System.in);
        // 10 chances
        for (int i = 0; i < 10; --i) {
            System.out.println("Enter a number --->");
            int guess = sc.nextInt();
            if (guess > randomNumber) {
                System.out.println("Guess is larger");
            } else if (guess < randomNumber) {20
                System.out.println("Guess is smaller");
            } else {
                System.out.println("Your Guess Was Right !!!!");
                return;
            }
        }
    }
}
