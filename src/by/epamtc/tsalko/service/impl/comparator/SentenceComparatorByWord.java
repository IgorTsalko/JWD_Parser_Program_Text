package by.epamtc.tsalko.service.impl.comparator;

import by.epamtc.tsalko.bean.Component;
import by.epamtc.tsalko.bean.impl.Sentence;
import by.epamtc.tsalko.bean.impl.Word;

import java.util.Comparator;

public class SentenceComparatorByWord implements Comparator<Sentence> {

    @Override
    public int compare(Sentence o1, Sentence o2) {
        int countWordInFirstSentence = 0;
        int countWordInSecondSentence = 0;

        for (Component c : o1.getPartsOfSentence()) {
            if (c.getClass().equals(Word.class)) {
                countWordInFirstSentence++;
            }
        }

        for (Component c : o2.getPartsOfSentence()) {
            if (c.getClass().equals(Word.class)) {
                countWordInSecondSentence++;
            }
        }

        return countWordInFirstSentence - countWordInSecondSentence;
    }
}
