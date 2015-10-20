package by.kliasheu.course.entities;

import java.util.*;

/**
 * Created by Misha on 10.04.2015.
 */
public class Text {
    private SortedMap<Integer, TextElement> text = new TreeMap<Integer, TextElement>();

    public void addElement(TextElement e, int position){
        text.put(position, e);
    }
    public List<Sentence> getSentences(){
        List<Sentence> sentences= new ArrayList<Sentence>();
        for (TextElement t : text.values()){
            if (t instanceof Sentence) sentences.add((Sentence)t);
        }
        return sentences;
    }
    public List<Word> getWords(){
        List<Word> words= new ArrayList<Word>();
        for (TextElement t : text.values()){
            if (t instanceof Sentence) {
                words.addAll(((Sentence) t).getWords());
            }
        }
        return words;
    }
    public String getText(){
        String result = "";
        Collection<TextElement> te = text.values();
        for (TextElement t: te){
            result = result + t.toString();
        }
        return result;
    }
    public Sentence getSentenceAt(int num){
        int i=0;
        for (TextElement t : text.values()){
            if (t instanceof Sentence){
                if (i==num) return (Sentence)t;
                i++;
            }
            else continue;
        }
        throw new IndexOutOfBoundsException();
    }
}
