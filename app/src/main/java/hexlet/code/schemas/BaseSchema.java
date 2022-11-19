package hexlet.code.schemas;

import java.util.HashMap;
import java.util.function.Predicate;


public class BaseSchema {
    protected boolean required = false;
    protected HashMap<String, Predicate<Object>> rules = new HashMap<>();

    /**
     * @param object Object that should be checked for any rules
     * @return Boolean
     */
    protected boolean initialCheck(Object object) {
        return true;
    }

    public final boolean isValid(Object object) {

        if (object == null) {
            return !required;
        }

        if (!initialCheck(object)) {
            return false;
        }

        return rules.values().stream()
                .map(objectPredicate -> (objectPredicate.test(object)))
                .reduce(Boolean::logicalAnd)
                .orElse(true);
    }
}
