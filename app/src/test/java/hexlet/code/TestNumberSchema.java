package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestNumberSchema {
    @Test
    public void testRequired() {
        var validator = new Validator();
        var schema = validator.number();

        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testPositive() {
        var validator = new Validator();
        var schema = validator.number();
        schema.positive();

        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-10));

        assertTrue(schema.isValid(5));
    }

    @Test
    public void testRange() {
        var validator = new Validator();
        var schema = validator.number();
        schema.range(3, 16);

        assertFalse(schema.isValid(1));
        assertFalse(schema.isValid(23));
        assertFalse(schema.isValid(-4));

        assertTrue(schema.isValid(9));
        assertTrue(schema.isValid(14));
    }
}
