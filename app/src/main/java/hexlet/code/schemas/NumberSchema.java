package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    private static final String REQUIRED = "REQUIRED";
    private static final String POSITIVE = "POSITIVE";
    private static final String RANGE = "RANGE";


    public NumberSchema positive() {
        Predicate<Object> predicate = object -> {
            var number = (Integer) object;
            if (number == null) {
                return true;
            }
            return number > 0;
        };
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
            var number = (Integer) object;
            if (number == null) {
                return true;
            }
            return number >= begin && number <= end;
        };
        rules.putIfAbsent(RANGE, predicate);

        return this;
    }
}
