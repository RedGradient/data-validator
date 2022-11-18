package hexlet.code;

import java.util.ArrayList;

public class StringSchema {

    private final ArrayList<String> substrings = new ArrayList<>();
    private boolean required = false;
    private boolean limitLength = false;
    private int minLength = 0;

    public StringSchema contains(String text) {
        substrings.add(text);
        return this;
    }

    public void required() {
        required = true;
    }

    public void minLength(int count) {
        limitLength = true;
        minLength = count;
    }

    public boolean isValid(String text) {
        if (text == null || text.isEmpty()) {
            return !required;
        }

        if (limitLength && text.length() < minLength) {
            return false;
        }

        for (var substring : substrings) {
            if (!text.contains(substring)) {
                return false;
            }
        }

        return true;
    }

}
