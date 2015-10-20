package by.kliasheu.course.entities;

/**
 * Created by Misha on 10.04.2015.
 */
public class Word extends BaseElement{
    private String content;

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (content != null ? !content.equals(word.content) : word.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Word() {
    }

    public Word(String content) {
        this.content = content;
    }
}
