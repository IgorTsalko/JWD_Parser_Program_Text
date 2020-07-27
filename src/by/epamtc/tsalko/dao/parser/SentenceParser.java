package by.epamtc.tsalko.dao.parser;

import by.epamtc.tsalko.bean.Sentence;
import by.epamtc.tsalko.bean.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private final WordParser wordParser = ParserFactory.getWordParser();

    // Разбирает текстовый блок на предложения (^.+\n)|(\s*?.+?\n*?.+?[.!?])
    private final String sentenceRegEx = "(\\.+.+[$\\n])|((\\d+\\.)+.+$)|((.+?\\n*?)+?[:.!?]\\s?)";
    // Разбивает текстовый блок на меньшие части чтобы не словить StackOverflowError
    private final String smallTextBlock = ".{3}(.*?\\n*?)+?[:.!?]\\s?";

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

//            System.out.print(sentence);
//            System.out.print(" || ");

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
