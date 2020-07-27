package by.epamtc.tsalko.dao.parser;

public class ParserFactory {

    private static ComponentParser componentParser;
    private static SentenceParser sentenceParser;
    private static WordParser wordParser;

    private ParserFactory() {}

    public static ComponentParser getComponentParser() {
        if (componentParser == null) {
            componentParser = new ComponentParser();
        }
        return componentParser;
    }

    public static SentenceParser getSentenceParser() {
        if (sentenceParser == null) {
            sentenceParser = new SentenceParser();
        }
        return sentenceParser;
    }

    public static WordParser getWordParser() {
        if (wordParser == null) {
            wordParser = new WordParser();
        }
        return wordParser;
    }
}
