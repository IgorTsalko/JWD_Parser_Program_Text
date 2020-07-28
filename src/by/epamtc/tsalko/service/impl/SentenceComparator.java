package by.epamtc.tsalko.service.impl;

import by.epamtc.tsalko.bean.impl.Sentence;

import java.util.Comparator;

public class SentenceComparator implements Comparator<Sentence> {

    @Override
    public int compare(Sentence o1, Sentence o2) {
        return o1.getSentence().size() - o2.getSentence().size();
    }
}
