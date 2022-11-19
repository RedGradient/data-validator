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

//        ArrayList<Boolean> checks = new ArrayList<>();
//        for (var rule : rules.values()) {
//            var middleResult = rule.test(object);
//            checks.add(middleResult);
//        }
//        var result = checks.stream().reduce(Boolean::logicalAnd).orElse(true);
//        return result;
    }
}
