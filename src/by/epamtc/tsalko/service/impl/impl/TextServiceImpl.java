package by.epamtc.tsalko.service.impl.impl;

import by.epamtc.tsalko.bean.Component;
import by.epamtc.tsalko.bean.impl.Sentence;
import by.epamtc.tsalko.bean.impl.Text;
import by.epamtc.tsalko.bean.impl.Word;
import by.epamtc.tsalko.service.impl.SentenceComparator;
import by.epamtc.tsalko.service.impl.TextService;

import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {

    private final SentenceComparator sentenceComparator = new SentenceComparator();

    @Override
    public List<Sentence> formSentencesAscending(Text text) {
        List<Sentence> sentences = getListSentences(text);
        sentences.sort(sentenceComparator);
        return sentences;
    }

    @Override
    public List<Sentence> formSentenceOppositeReplacementFirstLastWords(Text text) {
        List<Sentence> sentences = getListSentences(text);

        for (Sentence sentence : sentences) {
            List<Word> words = sentence.getSentence();

            if (words.get(words.size() - 1).getContent().equals("\n")) {
                // TODO
            }
        }

        return sentences;
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
