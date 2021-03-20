package utils;

import java.util.HashMap;
import java.util.Map;

//needs explanation
public class ContextMap<instance> {
    private static ContextMap instance;
    private static Map<String, Object> context = new HashMap<>();

    public ContextMap() {
    }

    public static ContextMap get(String email) {
        if (instance == null) {
            instance = new ContextMap();
        }
        return instance;
    }

    public static void clear() {
        context.clear();
    }

    public static <T> void put(String key, T object) {
        context.put(key, object);
    }

    public static <T> T get(String key, Class<T> userClass) {
        Object object;
        try {
            object = context.get(key);
        } catch (NullPointerException e) {
            throw new AssertionError(String.format("Object with key %s does not exist", key));
        }
        return userClass.cast(object);
    }
}
