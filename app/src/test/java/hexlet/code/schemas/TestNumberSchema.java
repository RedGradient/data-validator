package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestNumberSchema {
    @Test
    public void testRequired() {
        var schema = new NumberSchema();

        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testPositive() {
        var schema = new NumberSchema();
        schema.positive();

        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-10));

        assertTrue(schema.isValid(5));
    }

    @Test
    public void testRange() {
        var schema = new NumberSchema();
        schema.range(5, 15);

        assertFalse(schema.isValid(3));
        assertFalse(schema.isValid(20));

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(12));
    }

    @Test
    public void testSnakeCalling() {
        var schema1 = new NumberSchema();
        assertTrue(schema1.positive().isValid(3));

        var schema2 = new NumberSchema();
        assertTrue(schema2.range(-5, 15).isValid(7));

        var schema3 = new NumberSchema();
        assertFalse(schema3.required().isValid(null));
    }
}
