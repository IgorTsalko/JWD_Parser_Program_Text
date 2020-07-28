package by.epamtc.tsalko.bean.impl;

import by.epamtc.tsalko.bean.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements Component {

    private final List<Word> sentence;

    public Sentence() {
        sentence = new ArrayList<>();
    }

    @Override
    public String getContent() {
        StringBuilder buff = new StringBuilder();

        for (Component c : sentence) {
            buff.append(c.getContent());
        }

        return buff.toString();
    }

    public List<Word> getSentence() {
        return sentence;
    }

    public void addWord(Word word) {
        sentence.add(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return this.sentence.equals(sentence.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }
}
