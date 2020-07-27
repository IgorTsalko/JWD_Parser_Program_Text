package by.epamtc.tsalko.bean;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Component {

    private static int count = 0;

    private final List<Word> words;

    public Sentence() {
        words = new ArrayList<>();
        count++;
    }

    @Override
    public String forPrint() {
        StringBuilder buff = new StringBuilder();

        for (Component c : words) {
            buff.append(c.forPrint());
        }

        return buff.toString();
    }

    public List<Word> getWords() {
        return words;
    }

    public static int getCount() {
        return count;
    }

    public void addWord(Word word) {
        words.add(word);
    }
}
