import java.io.File;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws Exception {
        File file = new File("sample.txt");

        Scanner sc = new Scanner(file);
        int wordsCount = 0;
        while(sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String [] words = currentLine.split(" ");
            wordsCount += words.length;
        }
        System.out.println(wordsCount);
    }
}
