package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TestValidator {
    @Test
    public void testString() {
        var validator = new Validator();
        var schema = validator.string();

        assertInstanceOf(StringSchema.class, schema);
    }

    @Test
    public void testNumber() {
        var validator = new Validator();
        var schema = validator.number();

        assertInstanceOf(NumberSchema.class, schema);
    }

    @Test
    public void testMap() {
        var validator = new Validator();
        var schema = validator.map();

        assertInstanceOf(MapSchema.class, schema);
    }
}
