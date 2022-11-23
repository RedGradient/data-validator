package hexlet.code.schemas;

import java.util.HashSet;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    private static final String CONTAINS = "CONTAINS";
    private static final String MIN_LENGTH = "MIN_LENGTH";
    private static final String REQUIRED = "REQUIRED";

    private final HashSet<String> substrings = new HashSet<>();

    public StringSchema contains(String value) {
        substrings.add(value);

        Predicate<Object> predicate = object -> {
            var string = (String) object;
            for (var substring : substrings) {
                if (!string.contains(substring)) {
                    return false;
                }
            }
            return true;
        };
        addRule(CONTAINS, predicate);

        return this;
    }

    public StringSchema required() {
        Predicate<Object> predicate = object -> {
            var string = (String) object;
            return !string.isEmpty();
        };
        addRule(REQUIRED, predicate);

        required = true;
        return this;
    }

    public StringSchema minLength(int value) {
        Predicate<Object> predicate = object -> {
            var string = (String) object;
            return string.length() >= value;
        };
        addRule(MIN_LENGTH, predicate);

        return this;
    }
}
