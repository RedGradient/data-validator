package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    private static final String POSITIVE = "POSITIVE";
    private static final String RANGE = "RANGE";

    @Override
    protected boolean initialCheck(Object object) {
        return object instanceof Integer;
    }

    public NumberSchema positive() {
        Predicate<Object> predicate = object -> {
            var number = (Integer) object;
            return number > 0;
        };
        addRule(POSITIVE, predicate);

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
        addRule(RANGE, predicate);

        return this;
    }
}
