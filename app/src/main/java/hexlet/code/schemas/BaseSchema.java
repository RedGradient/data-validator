package hexlet.code.schemas;

import java.util.HashMap;
import java.util.function.Predicate;

public class BaseSchema {
    protected HashMap<String, Predicate<Object>> rules = new HashMap<>();

    public boolean isValid(Object object) {
        return rules.values().stream()
                .map(objectPredicate -> (objectPredicate.test(object)))
                .reduce(Boolean::logicalAnd)
                .orElse(true);
    }
}
