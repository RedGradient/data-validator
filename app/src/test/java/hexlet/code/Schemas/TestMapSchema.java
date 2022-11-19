package hexlet.code.Schemas;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMapSchema {
    @Test
    public void testRequired() {
        var schema = new MapSchema();

        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap()));
    }

    @Test
    public void testSizeof() {
        var schema = new MapSchema();

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");

        schema.sizeof(2);

        assertFalse(schema.isValid(map));
        map.put("key2", "value2");
        assertTrue(schema.isValid(map));
    }
}
