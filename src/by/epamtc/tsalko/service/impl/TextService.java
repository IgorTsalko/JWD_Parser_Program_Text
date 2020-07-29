package by.epamtc.tsalko.service.impl;

import by.epamtc.tsalko.bean.impl.Sentence;
import by.epamtc.tsalko.bean.impl.Text;
import by.epamtc.tsalko.bean.impl.Word;

import java.util.List;

public interface TextService {

    // №2
    List<Sentence> formSentencesAscending(Text text);

    // №5
    List<Sentence> formSentenceOppositeReplacementFirstLastWords(Text text);

    // №9
    List<Word> formSortedWordsByLetter(Text text, String letter);
}
