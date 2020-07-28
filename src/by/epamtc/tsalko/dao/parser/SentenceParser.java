package by.epamtc.tsalko.dao.parser;

import by.epamtc.tsalko.bean.impl.Sentence;
import by.epamtc.tsalko.bean.impl.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private final WordParser wordParser = ParserFactory.getWordParser();

    // Разбивает текстовый блок на меньшие части чтобы не словить StackOverflowError
    private final String smallTextBlock = "(.{10}(.*?\\n*?)+?[:.!?]\\s?)";
    // Разбирает текстовый блок на предложения
    private final String sentenceRegEx = "(\\.+.+[$\\n])|((\\d+\\.)+.+[$\\n])|((.+?\\n*?)+?[:.!?]\\s?)";

    public List<Sentence> parseSentences(String textBlock) {
        List<Sentence> sentences = new ArrayList<>();

        Pattern smallTextBlockPattern = Pattern.compile(smallTextBlock);
        Matcher smallTextBlockMatcher = smallTextBlockPattern.matcher(textBlock);

        while (smallTextBlockMatcher.find()) {
            Pattern sentencePattern = Pattern.compile(sentenceRegEx);
            Matcher sentenceMatcher = sentencePattern.matcher(smallTextBlockMatcher.group());

            while (sentenceMatcher.find()) {
                Sentence sentenceEntity = new Sentence();
                String sentence = sentenceMatcher.group();
                List<Word> words = wordParser.parseWord(sentence);

                for (Word w : words) {
                    sentenceEntity.addWord(w);
                }

                sentences.add(sentenceEntity);
            }
        }

        return sentences;
    }
}
