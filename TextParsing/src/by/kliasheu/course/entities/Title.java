package by.kliasheu.course.entities;

/**
 * Created by Misha on 24.04.2015.
 */
public class Title extends TextElement {
    private String content;

    public Title() {
    }

    public Title(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
