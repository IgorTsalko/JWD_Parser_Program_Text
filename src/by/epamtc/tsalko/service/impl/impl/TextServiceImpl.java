package by.epamtc.tsalko.service.impl.impl;

import by.epamtc.tsalko.bean.Component;
import by.epamtc.tsalko.bean.impl.Sentence;
import by.epamtc.tsalko.bean.impl.Text;
import by.epamtc.tsalko.bean.impl.Word;
import by.epamtc.tsalko.service.impl.comparator.SentenceComparatorByWord;
import by.epamtc.tsalko.service.impl.TextService;
import by.epamtc.tsalko.service.impl.comparator.WordComparatorAlphabetically;
import by.epamtc.tsalko.service.impl.comparator.WordComparatorByLetter;

import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {

    private SentenceComparatorByWord sentenceComparatorByWord = new SentenceComparatorByWord();
    private WordComparatorAlphabetically wordComparatorAlphabetically = new WordComparatorAlphabetically();

    @Override
    public List<Sentence> formSentencesAscending(Text text) {
        List<Sentence> sentences = getListSentences(text);
        sentences.sort(sentenceComparatorByWord);
        return sentences;
    }

    @Override
    public List<Sentence> formSentenceOppositeReplacementFirstLastWords(Text text) {
        List<Sentence> sentences = getListSentences(text);
        List<Sentence> formedSentences = new ArrayList<>();

        for (Sentence s : sentences) {
            Sentence editedSentence = new Sentence();

            Word firstWord = null;
            Word lastWord = null;
            for (Component c : s.getPartsOfSentence()) {
                if (c.getClass().equals(Word.class)) {
                    Word word = (Word) c;
                    if (firstWord == null) {
                        firstWord = word;
                    } else {
                        lastWord = word;
                    }
                }
                editedSentence.addPart(c);
            }

            if (firstWord != null && lastWord != null) {
                editedSentence.removePart(firstWord);
                editedSentence.removePart(lastWord);
                editedSentence.addPart(s.getPartsOfSentence().indexOf(firstWord), lastWord);
                editedSentence.addPart(s.getPartsOfSentence().indexOf(lastWord), firstWord);

                formedSentences.add(editedSentence);
            } else {
                formedSentences.add(s);
            }
        }

        return formedSentences;
    }

    @Override
    public List<Word> formSortedWordsByLetter(Text text, String letter) {
        List<Word> words = getListWords(text);
        words.sort(new WordComparatorByLetter(letter)
                .thenComparing(wordComparatorAlphabetically));

        return words;
    }

    private List<Sentence> getListSentences(Text text) {
        List<Sentence> sentences = new ArrayList<>();

        for (Component component : text.getText()) {
            if (component.getClass().equals(Sentence.class)) {
                Sentence sentence = (Sentence) component;
                sentences.add(sentence);
            }
        }

        return sentences;
    }

    private List<Word> getListWords(Text text) {
        List<Word> words = new ArrayList<>();

        for (Component component : text.getText()) {
            if (component.getClass().equals(Sentence.class)) {
                Sentence sentence = (Sentence) component;

                for (Component c : sentence.getPartsOfSentence()) {
                    if (c.getClass().equals(Word.class)) {
                        Word word = (Word) c;
                        words.add(word);
                    }
                }
            }
        }

        return words;
    }
}
