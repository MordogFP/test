package by.kliasheu.course.Util;

import by.kliasheu.course.entities.Sentence;
import by.kliasheu.course.entities.Text;
import by.kliasheu.course.entities.Word;

/**
 * Created by Misha on 27.04.2015.
 */
public class UniqueWord {
    public static String findUniqueWord(Text text){
        String result = "";
        Sentence firstSentence = text.getSentenceAt(0);
        System.out.println(firstSentence.toString());
        firstSentence:
        for (Word w : firstSentence.getWords()){
            boolean b = false;
            for (Sentence s : text.getSentences()){
                if (b == true) {
                    for (Word word : s.getWords()){
                        if (w.equals(word)) continue firstSentence;
                    }
                }
                else{
                    b = true;
                    continue;
                }
            }
            result = w.toString();
        }
        return result;
    }
}
