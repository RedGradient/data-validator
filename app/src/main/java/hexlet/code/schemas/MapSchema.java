package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    private static final String REQUIRED = "REQUIRED";
    private static final String SIZEOF = "SIZEOF";

    public MapSchema required() {
        Predicate<Object> predicate = Objects::nonNull;
        rules.putIfAbsent(REQUIRED, predicate);
        return this;
    }

    public MapSchema sizeof(int value) {
        Predicate<Object> predicate = object -> ((Map) object).size() == value;
        rules.putIfAbsent(SIZEOF, predicate);
        return this;
    }

}
