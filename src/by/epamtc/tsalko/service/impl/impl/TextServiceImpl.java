package by.epamtc.tsalko.service.impl.impl;

import by.epamtc.tsalko.bean.Component;
import by.epamtc.tsalko.bean.Sentence;
import by.epamtc.tsalko.bean.Text;
import by.epamtc.tsalko.bean.Word;
import by.epamtc.tsalko.main.print.PrintComponent;
import by.epamtc.tsalko.service.impl.SentenceComparator;
import by.epamtc.tsalko.service.impl.TextService;

import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {

    private final PrintComponent printComponent = new PrintComponent();

    @Override
    public void printSentencesAscending(Text text) {
        List<Sentence> sentences = getListSentences(text);

        sentences.sort(new SentenceComparator());

        printComponent.printSentences(sentences);
    }

    @Override
    public void printSentenceOppositeReplacementFirstLastWords(Text text) {
        List<Sentence> sentences = getListSentences(text);

        for (Sentence sentence : sentences) {
            List<Word> words = sentence.getWords();

            if (words.get(words.size() - 1).getWord().equals("\n")) {
            }
        }
    }

    private List<Sentence> getListSentences(Text text) {
        List<Sentence> sentences = new ArrayList<>();

        for (Component component : text.getText()) {
            if (component.getClass().getSimpleName().equalsIgnoreCase("sentence")) {
                Sentence sentence = (Sentence) component;
                sentences.add(sentence);
            }
        }

        return sentences;
    }
}
