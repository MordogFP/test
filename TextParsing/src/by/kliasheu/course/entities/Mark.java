package by.kliasheu.course.entities;

/**
 * Created by Misha on 10.04.2015.
 */
public class Mark extends BaseElement{
    private char content;

    public Mark() {
    }

    public Mark(char content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ""+content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark = (Mark) o;

        if (content != mark.content) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) content;
    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }
}
