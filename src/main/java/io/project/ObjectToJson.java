package io.project;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
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

        StringJoiner joiner = new StringJoiner(", ");
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            String s = "\"" + entry.getKey() + "\":\""
                    + entry.getValue() + "\"";
            joiner.add(s);
        }
        String jsonString = joiner.toString();
        System.out.println(jsonString);
        return "{" + jsonString + "}";
    }

    public void write(List<String> listOfClients) {

        String prefix = "[";
        String postfix = "]";
        try (FileWriter writer = new FileWriter("src/main/resources/output.json")) {
            writer.write(prefix);
            for (int i = 0; i < listOfClients.size(); i++) {
                if (i < listOfClients.size() - 1) {
                    writer.write(listOfClients.get(i) + "," + "\n");
                } else {
                    writer.write(listOfClients.get(i) + "\n");
                }
            }
            writer.write(postfix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
