package hexlet.code.Schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    private static final String REQUIRED = "REQUIRED";
    private static final String POSITIVE = "POSITIVE";
    private static final String RANGE = "RANGE";


    public NumberSchema positive() {
        Predicate<Object> predicate = number -> ((int) number > 0);
        rules.putIfAbsent(POSITIVE, predicate);

        return this;
    }

    public NumberSchema required() {
        Predicate<Object> predicate = Objects::nonNull;
        rules.putIfAbsent(REQUIRED, predicate);

        return this;
    }

    public NumberSchema range(int begin, int end) {
        Predicate<Object> predicate = object -> {
            var number = (int) object;
            return number >= begin && number <= end;
        };
        rules.putIfAbsent(RANGE, predicate);

        return this;
    }
}
