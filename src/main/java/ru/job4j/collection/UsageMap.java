package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("job4j@mail.ru", "MakcuM CABUH");
        map.put("tonnagovna@mail.ru", "Tolik Tolik");

/*
метод keySet() возвращает коллекцию java.util.Set состоящую только из ключей.
Через метод get получаем значение ассоциированное с этим ключом
 */
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

/*
метод entrySet() возвращает коллекцию java.util.Set состоящую из объекта Map.Entry,
которая сразу содержит и ключ и значение
 */
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
