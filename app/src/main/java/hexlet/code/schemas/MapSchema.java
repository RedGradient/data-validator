package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
//    private static final String REQUIRED = "REQUIRED";
    private static final String SIZEOF = "SIZEOF";
    private static final String SHAPE = "SHAPE";

    public MapSchema required() {
//        Predicate<Object> predicate = Objects::nonNull;
//        rules.putIfAbsent(REQUIRED, predicate);
        required = true;
        return this;
    }

    public MapSchema sizeof(int value) {
        Predicate<Object> predicate = object -> ((Map) object).size() == value;
        rules.putIfAbsent(SIZEOF, predicate);
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> predicate = object -> {
            var map = (Map) object;
            for (var pair : schemas.entrySet()) {
                var key = pair.getKey();
                var schema = pair.getValue();
                if (!schema.isValid(map.get(key))) {
                    return false;
                }
            }
            return true;
        };

        rules.putIfAbsent(SHAPE, predicate);
    }
}
