package by.epamtc.tsalko.dao.parser;

import by.epamtc.tsalko.bean.impl.Sentence;
import by.epamtc.tsalko.bean.impl.Word;
import by.epamtc.tsalko.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    // Разбивает текстовый блок на меньшие части чтобы не словить StackOverflowError
    private final String smallTextBlock = PropertyReader.getInstance().getProperty("smallTextBlock");
    // Разбирает текстовый блок на предложения
    private final String sentenceRegEx = PropertyReader.getInstance().getProperty("sentenceRegEx");

    private final WordParser wordParser = ParserFactory.getWordParser();
    private final Pattern smallTextBlockPattern = Pattern.compile(smallTextBlock);
    private final Pattern sentencePattern = Pattern.compile(sentenceRegEx);


    public List<Sentence> parseSentences(String textBlock) {
        List<Sentence> sentences = new ArrayList<>();

        Matcher smallTextBlockMatcher = smallTextBlockPattern.matcher(textBlock);

        while (smallTextBlockMatcher.find()) {
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
