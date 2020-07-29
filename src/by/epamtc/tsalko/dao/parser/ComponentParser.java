package by.epamtc.tsalko.dao.parser;

import by.epamtc.tsalko.bean.impl.CodeBlock;
import by.epamtc.tsalko.bean.impl.Sentence;
import by.epamtc.tsalko.bean.impl.Text;
import by.epamtc.tsalko.dao.exception.DAOException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComponentParser {

    private final SentenceParser sentenceParser = ParserFactory.getSentenceParser();

    private final String componentsRegExp = PropertyReader.getInstance().getProperty("componentsRegExp");
    private final Pattern pattern = Pattern.compile(componentsRegExp);


    public Text createText(String allText) {
        Text text = new Text();

        Matcher matcher = pattern.matcher(allText);

        while (matcher.find()) {
            String textBlock = matcher.group("TextBlock");
            String codeBLock = matcher.group("CodeBlock");

            if (textBlock != null) {
                List<Sentence> sentences = sentenceParser.parseSentences(textBlock);
                for (Sentence s : sentences) {
                    text.addTextComponent(s);
                }
            }

            if (codeBLock != null) {
                text.addTextComponent(new CodeBlock(codeBLock));
            }
        }

        return text;
    }
}
