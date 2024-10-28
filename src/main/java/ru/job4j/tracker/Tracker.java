package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
/* Добавляет заявку в массив заявок items.
Устанавливает уникальный ключ в объект Item item с помощью метода setId.
Добавляет item в массив items.
 */
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
/* Возвращает все заявки из массива items.
Создает новый массив result для хранения найденных заявок.
Итерируется по массиву items и добавляет ненулевые заявки в result.
 */
        Item[] result = new Item[size];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            Item item = this.items[index];
            if (item != null) {
                result[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item[] findByName(String key) {
/* Возвращает заявки с заданным именем.
Создает новый массив result для хранения найденных заявок.
Итерируется по массиву items и добавляет заявки с именем, соответствующим key, в result.
 */
        Item[] result = new Item[size];
        int count = 0;
        for (int index = 0; index < this.size; index++) {
            Item item = this.items[index];
            if (item.getName().equalsIgnoreCase(key)) {
                result[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Item findById(int id) {
/* Возвращает заявку по заданному идентификатору.
Ищет индекс заявки с заданным id с помощью метода indexOf.
Возвращает заявку по найденному индексу или null, если заявка не найдена.
 */
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    //  НОВАЯ ЗАДАЧА
    private int indexOf(int id) {
/* Возвращает индекс заявки по заданному идентификатору.
Ищет индекс заявки с заданным id в массиве items.
Возвращает индекс найденной заявки или -1, если заявка не найдена.
 */
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
/* Заменяет заявку с заданным идентификатором на новую заявку.
1. Найти индекс ячейки по id.
2. Проставить id с item. При замене нужно сохранять старый id.
3. Записать в ячейку с найденным индексом объект item. Это входящий параметр.
4. Вернуть true, если замена произведена или false, если index по id не найден.
 */
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }
}