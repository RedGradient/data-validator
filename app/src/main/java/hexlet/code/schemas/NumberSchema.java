package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    private static final String POSITIVE = "POSITIVE";
    private static final String RANGE = "RANGE";
    private static final String INITIAL = "INITIAL";


    public NumberSchema() {
        Predicate<Object> predicate = object -> object instanceof Integer;
        rules.put(INITIAL, predicate);
    }

    public NumberSchema positive() {
        Predicate<Object> predicate = object -> {
            var number = (Integer) object;
            return number > 0;
        };
        rules.putIfAbsent(POSITIVE, predicate);

        return this;
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema range(int begin, int end) {
        Predicate<Object> predicate = object -> {
            var number = (Integer) object;
            return number >= begin && number <= end;
        };
        rules.putIfAbsent(RANGE, predicate);

        return this;
    }
}
