package by.epamtc.tsalko.service.impl.comparator;

import by.epamtc.tsalko.bean.impl.Word;

import java.util.Comparator;

public class WordComparatorByLetter implements Comparator<Word> {

    private String letter;

    public WordComparatorByLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public int compare(Word o1, Word o2) {
        int c1 = countLetter(o1, letter);
        int c2 = countLetter(o2, letter);

        return Integer.compare(c1, c2);
    }

    private int countLetter(Word word, String letter) {
        String w = word.getWord();
        return w.length() - w.replace(letter, "").length();
    }
}
