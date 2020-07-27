package by.epamtc.tsalko.bean;

import java.util.ArrayList;
import java.util.List;

public class Text implements Component {

    private final List<Component> text;

    public Text() {
        this.text = new ArrayList<>();
    }

    public List<Component> getText() {
        return text;
    }

    public void addTextComponent(Component component) {
        text.add(component);
    }

    @Override
    public String forPrint() {
        StringBuilder buff = new StringBuilder();

        for (Component c : text) {
            buff.append(c.forPrint());
        }

        return buff.toString();
    }
}
