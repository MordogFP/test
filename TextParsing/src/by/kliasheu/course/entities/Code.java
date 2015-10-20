package by.kliasheu.course.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Misha on 10.04.2015.
 */
public class Code extends TextElement{
    private List<CodeLine> lines;

    @Override
    public String toString() {
        String result = "";
        for (CodeLine str : lines){
            result+=str;
        }
        return result;
    }

    public void addElement(CodeLine str){
        lines.add(str);
    }

    public Code() {
        lines = new ArrayList<CodeLine>();
    }

    public Code(List<CodeLine> lines) {
        this.lines = lines;
    }
/*public String content;

    public Code() {
    }

    public Code(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }*/
}
