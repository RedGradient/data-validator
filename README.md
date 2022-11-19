### Hexlet tests and linter status:
[![Actions Status](https://github.com/RedGradient/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/RedGradient/java-project-78/actions)
[![Actions Status](https://github.com/RedGradient/java-project-78/workflows/build/badge.svg)](https://github.com/RedGradient/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/18c11c3e4854549bcddd/maintainability)](https://codeclimate.com/github/RedGradient/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/18c11c3e4854549bcddd/test_coverage)](https://codeclimate.com/github/RedGradient/java-project-78/test_coverage)

# Data Validator (Education Project)
A simple validator library that checks the passed object according to the established rules and returns true or false.
Validator can be used for String, Integer and Map objects.

## Examples

### StringSchema
```jshelllanguage
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();

StringSchema schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid(5); // false
schema.isValid(""); // false

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// уже false, так как добавлена ещё одна проверка contains("whatthe")
```

### NumberSchema
```jshelllanguage
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

Validator v = new Validator();

NumberSchema schema = v.number();

schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10) // true
schema.isValid("5"); // false
schema.isValid(-10); // false
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```

### MapSchema
```jshelllanguage
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

Validator v = new Validator();

MapSchema schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```