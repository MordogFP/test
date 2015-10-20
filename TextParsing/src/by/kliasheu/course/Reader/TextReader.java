package by.kliasheu.course.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Misha on 25.04.2015.
 */
public class TextReader {
    public static String readText(String URL) throws FileNotFoundException {
        File file = new File(URL);
        Scanner scan = new Scanner(file);
        String text = "";

        while (scan.hasNext()){
            text=text+scan.nextLine()+"\n";
        }
        return text;
    }
}
