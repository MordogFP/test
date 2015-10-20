package by.kliasheu.course.entities;

/**
 * Created by Misha on 27.04.2015.
 */
public class CodeLine extends BaseElement{
    private String line;

    public String toString(){
        return line;
    }

    public CodeLine() {
    }

    public CodeLine(String line) {
        this.line = line;
    }
}
