package by.epamtc.tsalko.dao.parser;

import by.epamtc.tsalko.bean.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    // Разделяет предложение на слова и знаки препинания
    private final String wordRegEx = "(\\w+|\\W)";

    public List<Word> parseWord(String sentence) {
        List<Word> words = new ArrayList<>();

        Pattern pattern = Pattern.compile(wordRegEx);
        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {
            words.add(new Word(matcher.group().intern()));
        }

        return words;
    }
}
