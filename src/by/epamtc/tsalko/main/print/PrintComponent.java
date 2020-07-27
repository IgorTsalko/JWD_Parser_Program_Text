package by.epamtc.tsalko.main.print;

import by.epamtc.tsalko.bean.Component;
import by.epamtc.tsalko.bean.Sentence;
import by.epamtc.tsalko.bean.Word;

import java.util.List;

public class PrintComponent {

    public void printComponents(Component component) {
        System.out.println(component.forPrint());
    }

    public void printSentences(List<Sentence> sentences) {
        StringBuilder buff = new StringBuilder();

        for (Component c : sentences) {
            String sentence = c.forPrint().replaceAll("\\n+", " ");
            buff.append(sentence).append("\n");
        }

        System.out.println(buff.toString());
    }

    public void printWords(List<Word> components) {
        StringBuilder buff = new StringBuilder();

        for (Word w : components) {
            String sentence = w.forPrint();
            buff.append(sentence).append("\n");
        }

        System.out.println(buff.toString());
    }
}
