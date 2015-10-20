package by.kliasheu.course;

import by.kliasheu.course.Parser.Parser;
import by.kliasheu.course.Reader.TextReader;
import by.kliasheu.course.Util.Palindrome;
import by.kliasheu.course.Util.Sorter;
import by.kliasheu.course.Util.UniqueWord;
import by.kliasheu.course.entities.*;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String str = TextReader.readText("src/resources/text.txt");
        Text text = Parser.parseText(str);
        System.out.println(text.getText());
        //System.out.println("\nThe longest Palindrome in text is: " + Palindrome.findPalindrome(text));
        //System.out.println("The word is: "+ UniqueWord.findUniqueWord(text));
        //System.out.println(Sorter.sortAlphabetically(text));
    }
}
