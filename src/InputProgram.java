import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Tank on 5/20/2015.
 */
public class InputProgram {
    public static void main(String[] args) {
        String data = "Lab2\\inputfiles\\words-5757.dat";
        String inWords = "Lab2\\inputfiles\\words-5757-test.in";
        String outWords = "Lab2\\inputfiles\\words-5757-test.out";
        File inWordsFile = new File(inWords);
        File outWordsFile = new File(outWords);
        Scanner scan = null;

        try {
            scan = new Scanner(inWordsFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            while (scan.hasNext()){
                String firstWord = scan.next();
                String secondWord = scan.next();
                args = new String[3];
                args[0] = firstWord;
                args[1] = secondWord;
                args[2] = data;
                WorldLadders.main(args);
            }

    }
}
