import java.util.ArrayList;
import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        MovieSelector selector = new MovieSelector("movies.txt");
        String movie = selector.select();
        UserInteraction ui = new UserInteraction();
        GuessTheMovie gtm = new GuessTheMovie();
        gtm.processor(movie, ui);
    }

    private void processor(String movie, UserInteraction ui) {
        int movieLength = movie.length();
        char[] movieGuessed = new char[movieLength];
        ArrayList wronglyGuessedLetters = new ArrayList();
        fillGuessArray(movie, movieGuessed);

        ui.prompt(movieGuessed, wronglyGuessedLetters);
        Scanner sc = new Scanner(System.in);
        String currentGuess;
        while (true) {
            checkForScore(movie, movieGuessed, wronglyGuessedLetters, ui);
            currentGuess = sc.nextLine();
            char sanitizedGuess = ui.sanitizeInput(currentGuess);
            if (sanitizedGuess != Character.MIN_VALUE) {
                updateGuessedMovie(sanitizedGuess, movie, movieGuessed, wronglyGuessedLetters);
                ui.prompt(movieGuessed, wronglyGuessedLetters);
            } else {
                System.out.println("Please enter correct input. Try Again!");
                continue;
            }
        }
    }

    private void checkForScore(String movie, char[] movieGuessed, ArrayList wronglyGuessedLetters, UserInteraction ui) {
        boolean atLeastOneMissing = false;
        for (int i = 0; i < movieGuessed.length; ++i) {
            if (movieGuessed[i] == '_') {
                atLeastOneMissing = true;
            }
        }

        if (!atLeastOneMissing) {
            // exit game you WIN!
            ui.win(movie);
            System.exit(0);
        }

        if(wronglyGuessedLetters.size() >= 10) {
            ui.lose();
            System.exit(0);
        }

    }

    private void updateGuessedMovie(char guessedLetter,
            String movie,
            char[] movieGuessed,
            ArrayList wronglyGuessedLetters
    ) {
        boolean first = true;
        int index = movie.indexOf(guessedLetter);
        while (index >= 0) {
            movieGuessed[index] = guessedLetter;
            index = movie.indexOf(guessedLetter, index + 1);
            first = false;
        }
        if (first) {
            wronglyGuessedLetters.add(guessedLetter);
        }
    }

    private char[] fillGuessArray(String movie, char[] guess) {
        for (int i = 0; i < movie.length(); ++i) {
            if (movie.charAt(i) == ' ') {
                guess[i] = ' ';
            } else {
                guess[i] = '_';
            }
        }
        return guess;
    }
}
