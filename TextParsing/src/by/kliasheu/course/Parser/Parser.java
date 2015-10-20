package by.kliasheu.course.Parser;

import by.kliasheu.course.entities.*;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Misha on 25.04.2015.
 */
public class Parser{


    public static Text parseText(String text) throws MissingResourceException {
        Text result = new Text();
        parseTitle(text, result);
        parseCode(text, result);
        parseSentence(text, result);

        return result;
    }

    public static Text parseTitle(String text, Text destination) throws MissingResourceException {
        ResourceBundle regex = ResourceBundle.getBundle("resources.regexLiterals");
        String titleRegex = regex.getString("title");
        Pattern titlePattern = Pattern.compile(titleRegex);
        Matcher m = titlePattern.matcher(text);
        while (m.find()){
            destination.addElement(new Title(m.group()), m.start());
        }
        return destination;
    }
    public static Text parseSentence(String text, Text destination) throws MissingResourceException {
        ResourceBundle regex = ResourceBundle.getBundle("resources.regexLiterals");
        String sentenceRegex = regex.getString("sentence");
        Pattern sentencePattern = Pattern.compile(sentenceRegex);
        Matcher m = sentencePattern.matcher(text);
        while (m.find()){
            String sentenceText = m.group();
            int sentencePosition = m.start();
            Sentence sentence = new Sentence();
            sentence = parseWords(sentenceText, sentence);
            sentence = parseMarks(sentenceText, sentence);
            destination.addElement(sentence, sentencePosition);
            //System.out.println(sentence.toString());
            //System.out.println("----------------------");
        }
        return destination;
    }
    public static Text parseCode(String text, Text destination) throws MissingResourceException {
        ResourceBundle regex = ResourceBundle.getBundle("resources.regexLiterals");
        String codeRegex = regex.getString("code");
        Pattern codePattern = Pattern.compile(codeRegex);
        Matcher m = codePattern.matcher(text);
        while (m.find()){
            String codeText = m.group();
            int codePosition = m.start();
            Code code = new Code();
            code=parseCodeLines("\n"+codeText, code);
            destination.addElement(code, codePosition);
        }
        return destination;
    }
    public static Code parseCodeLines(String codeText, Code destination){
        ResourceBundle regex = ResourceBundle.getBundle("resources.regexLiterals");
        String codeLineRegex = regex.getString("codeLine");
        Pattern codeLinePattern = Pattern.compile(codeLineRegex);
        Matcher m = codeLinePattern.matcher(codeText);
        while (m.find()){
            destination.addElement(new CodeLine(m.group()));
        }
        return destination;
    }
    public static Sentence parseWords(String sentenceText, Sentence destination){
        ResourceBundle regex = ResourceBundle.getBundle("resources.regexLiterals");
        String wordRegex = regex.getString("word");
        Pattern wordPattern = Pattern.compile(wordRegex);
        Matcher m = wordPattern.matcher(sentenceText);
        while (m.find()){
            destination.addElement(new Word(m.group()), m.start());
        }
        return destination;
    }
    public static Sentence parseMarks(String sentenceText, Sentence destination){
        ResourceBundle regex = ResourceBundle.getBundle("resources.regexLiterals");
        String markRegex = regex.getString("mark");
        Pattern markPattern = Pattern.compile(markRegex);
        Matcher m = markPattern.matcher(sentenceText);
        while (m.find()){
            destination.addElement(new Mark(m.group().charAt(0)), m.start());
        }
        return destination;
    }
}
