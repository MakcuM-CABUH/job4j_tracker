package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
/* Добавляет заявку, переданную в аргументах в массив заявок items.
В методе add нужно проставить уникальный ключ в объект Item item. Это нужно сделать через метод setId
 */
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            Item item = this.items[index];
            if (item != null) {
                result[size] = item;
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int count = 0;
        for (int index = 0; index < this.size; index++) {
            Item item = this.items[index];
            if (item.getName().equalsIgnoreCase(key)) {
                result[count] = item;
                count++;
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }

    public Item findById(int id) {
        Item result = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }
}