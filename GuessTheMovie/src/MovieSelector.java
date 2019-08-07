import java.io.File;
import java.util.Scanner;

public class MovieSelector {

    File file;

    MovieSelector(String file) {
        this.file = new File(file);
    }

    public String select() throws Exception {
        int lines = 0;
        Scanner sc = new Scanner(file);
        String [] moviesList = new String[100];
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            moviesList[lines] = name;
            lines++;
        }
        int movieIndex = (int) (Math.random() * lines);
        return moviesList[movieIndex];
    }
}
