package hexlet.code.schemas;

import java.util.HashMap;
import java.util.function.Predicate;

public class BaseSchema {
    protected boolean required = false;
    protected HashMap<String, Predicate<Object>> rules = new HashMap<>();

    public boolean isValid(Object object) {

        if (object == null) {
            return !required;
        }

        return rules.values().stream()
                .map(objectPredicate -> (objectPredicate.test(object)))
                .reduce(Boolean::logicalAnd)
                .orElse(true);

    }
}
