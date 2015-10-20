package by.kliasheu.course.Util;

import by.kliasheu.course.entities.Text;
import by.kliasheu.course.entities.Title;
import by.kliasheu.course.entities.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Misha on 27.04.2015.
 */
public class Sorter {
    public static List<Word> sortAlphabetically(Text text){
        List<Word> words = new ArrayList<Word>();
        String regex = "^[aeyuioAEYUIO]\\w+";
        Pattern p = Pattern.compile(regex);
        for (Word w : text.getWords()){
            Matcher m = p.matcher(w.toString());
            while (m.find()){
                words.add(w);
            }
        }
        class MyComparator<Word> implements Comparator<Word> {
            public int compare(Word w1, Word w2){
                if (w1.toString().toLowerCase().charAt(0) > w2.toString().toLowerCase().charAt(0)) return 1;
                if (w1.toString().toLowerCase().charAt(0) == w2.toString().toLowerCase().charAt(0)) return 0;
                return -1;
            }
        }
        Collections.sort(words, new MyComparator<Word>());
        return words;
    }
}
