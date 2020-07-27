package by.epamtc.tsalko.dao.parser;

import by.epamtc.tsalko.bean.CodeBlock;
import by.epamtc.tsalko.bean.Sentence;
import by.epamtc.tsalko.bean.Text;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComponentParser {

    private final SentenceParser sentenceParser = ParserFactory.getSentenceParser();

    // Разделяет текст на абзацы и блоки кода
    private final String componentsRegExp = "(?<TextBlock>[^{}]+\\n)" +
                                            "|" +
                                            "(?<CodeBlock>.*\\{\\n(.*\\n)+?\\n*}\\n)";

    public Text createText(String allText) {
        Text text = new Text();

        Pattern pattern = Pattern.compile(componentsRegExp);
        Matcher matcher = pattern.matcher(allText);

        while (matcher.find()) {
            String textBlock = matcher.group("TextBlock");
            String codeBLock = matcher.group("CodeBlock");

            if (textBlock != null) {
                List<Sentence> sentences = sentenceParser.parseSentences(textBlock);
                for (Sentence s : sentences) {
                    text.addTextComponent(s);
                }

//                System.out.println(textBlock);
//                System.out.println("________________________________________________________________");
            }

            if (codeBLock != null) {
                text.addTextComponent(new CodeBlock(codeBLock));

//                System.out.println(codeBLock);
//                System.out.println("________________________________________________________________");
            }
        }

        return text;
    }
}
