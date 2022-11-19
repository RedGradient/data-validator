package hexlet.code.schemas;

import java.util.HashSet;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    private static final String CONTAINS = "CONTAINS";
    private static final String MIN_LENGTH = "MIN_LENGTH";
    private static final String REQUIRED = "REQUIRED";

    private final HashSet<String> substrings = new HashSet<>();

    public StringSchema contains(String value) {
        substrings.add(value);

        Predicate<Object> predicate = object -> {
            var string = (String) object;
            if (string == null) {
                return true;
            }
            for (var substring : substrings) {
                if (!string.contains(substring)) {
                    return false;
                }
            }
            return true;
        };
        rules.putIfAbsent(CONTAINS, predicate);

        return this;
    }

    public StringSchema required() {
        Predicate<Object> predicate = object -> {
            var string = (String) object;
            return string != null && !string.isEmpty();
        };
        rules.putIfAbsent(REQUIRED, predicate);

        return this;
    }

    public StringSchema minLength(int value) {
        Predicate<Object> predicate = object -> {
            var string = (String) object;
            if (string == null) {
                return true;
            }
            return string.length() >= value;
        };
        rules.put(MIN_LENGTH, predicate);

        return this;
    }
}
