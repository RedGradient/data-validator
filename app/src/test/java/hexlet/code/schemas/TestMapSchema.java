package hexlet.code.schemas;

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

    @Test
    public void testSnakeCall() {
        var schema = new MapSchema();

        assertFalse(schema.required().isValid(null));

        Map<String, String> map = new HashMap<>();
        assertFalse(schema.sizeof(2).isValid(map));
    }

    @Test
    public void testNestedValidation() {

        MapSchema mapSchema = new MapSchema();

        Map<String, BaseSchema> schemas = new HashMap<>();
        StringSchema stringSchema = new StringSchema();
        NumberSchema numberSchema = new NumberSchema();

        schemas.put("name", stringSchema.required());
        schemas.put("age", numberSchema.positive());

        mapSchema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(mapSchema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(mapSchema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(mapSchema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(mapSchema.isValid(human4));
    }
}
