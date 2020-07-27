package by.epamtc.tsalko.bean;


public class CodeBlock implements Component {

    private final String codeBlock;

    public CodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    @Override
    public String forPrint() {
        return codeBlock;
    }

    public String getCodeBlock() {
        return codeBlock;
    }
}
