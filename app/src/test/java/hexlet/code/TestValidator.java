package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TestValidator {
    @Test
    public void testString() {
        var validator = new Validator();
        var schema = validator.string();

        assertInstanceOf(StringSchema.class, schema);
    }
}
