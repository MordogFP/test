package by.kliasheu.course.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Misha on 10.04.2015.
 */
public class Sentence extends TextElement{
    private SortedMap<Integer, BaseElement> content = new TreeMap<Integer, BaseElement>();
    //public String content;
    public void addElement(BaseElement el, int position){
        content.put(position, el);
    }
    public List<Word> getWords(){
        List<Word> words = new ArrayList<Word>();
        for (BaseElement el : content.values()){
            if (el instanceof Word) words.add((Word)el);
        }
        return words;
    }
    public Sentence() {
    }

    public Sentence(SortedMap<Integer, BaseElement> content) {
        this.content = content;
    }

    public SortedMap<Integer, BaseElement> getContent() {
        return content;
    }

    public void setContent(SortedMap<Integer, BaseElement> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        String result = "";
        for (BaseElement el : content.values()){
            result+=el.toString();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (content != null ? !content.equals(sentence.content) : sentence.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
    /*public Sentence() {
    }

    public Sentence(String content) {
        this.content = content;
    }
    public String toString() {
        return content;
    }*/
}
