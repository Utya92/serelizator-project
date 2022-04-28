package io.project;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class ObjectToJson {

    public String convertToJson(Object o) {
        try {
            return getJsonToString(o);
        } catch (Exception e) {
            throw new RuntimeException("converting failed");

        }
    }

 
    private String getJsonToString(Object o) throws IllegalAccessException {
        Class<?> clazz = o.getClass();
        Map<String, String> jsonElements = new LinkedHashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElements.put(field.getName(), (String) field.get(o));
            }
        }

        StringJoiner joiner = new StringJoiner(",");
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            String s = "\"" + entry.getKey() + "\":\""
                    + entry.getValue() + "\"";
            joiner.add(s);
        }
        String jsonString = joiner.toString();
        System.out.println(jsonString);
        return "{" + jsonString + "}";
    }


}


























