package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * Добавляет заявку в массив заявок items.
     * Устанавливает уникальный ключ в объект Item item с помощью метода setId.
     * Добавляет item в массив items.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Возвращает все заявки из массива items.
     * Создает новый массив result для хранения найденных заявок.
     * Итерируется по массиву items и добавляет ненулевые заявки в result.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Возвращает заявки с заданным именем.
     * Создает новый массив result для хранения найденных заявок.
     * Итерируется по массиву items и добавляет заявки с именем, соответствующим key, в result.
     */
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
        return Arrays.copyOf(result, count);
    }

    /**
     * Возвращает заявку по заданному идентификатору.
     * Ищет индекс заявки с заданным id с помощью метода indexOf.
     * Возвращает заявку по найденному индексу или null, если заявка не найдена.
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Возвращает индекс заявки по заданному идентификатору.
     * Ищет индекс заявки с заданным id в массиве items.
     * Возвращает индекс найденной заявки или -1, если заявка не найдена.
     */
    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    /**
     * Заменяет заявку с заданным идентификатором на новую заявку.
     * 1. Найти индекс ячейки по id.
     * 2. Проставить id с item. При замене нужно сохранять старый id.
     * 3. Записать в ячейку с найденным индексом объект item. Это входящий параметр.
     * 4. Вернуть true, если замена произведена или false, если index по id не найден.
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    /**
     * проверяем "входящие" данные на соответствие параметрам массива...
     * -> действия с массивом производим только если "входящие" данные валидны
     * удаляем нужную ячейку - сдвигаем оставшуюся часть массива влево...
     * модель:  System.arraycopy(source, startPos, dist, distPos, length);
     * source - массив ОТКУДА копируем элементы      (у нас "items")
     * startPos - стартовая позиция копирования      (у нас "index + 1")
     * dist - массив, КУДА вставить скопированные элементы (можно в тот же массив)
     * (у нас "items" - тот же массив, но можно и другой)
     * distPos - начиная с какого элемента вставлять скопированные ячейки.
     * (у нас "index")
     * length - сколько элементов КОПИРУЕМ начиная от startPos
     * (у нас "items.length - 1 - index")
     */
    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            if (items[index].getId() == id) {
                System.arraycopy(items, index + 1, items, index, size - 1 - index);
                items[size - 1] = null;
                size--;
            }
        }
    }
}