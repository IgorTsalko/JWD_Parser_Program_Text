package by.epamtc.tsalko.bean;

public class Word implements Component {

    private static int count = 0;

    private final String word;

    public Word(String word) {
        this.word = word;
        count++;
    }

    @Override
    public String forPrint() {
        return word;
    }

    public static int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }


}
