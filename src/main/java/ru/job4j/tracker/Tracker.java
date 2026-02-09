package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    /**
     * Добавляет заявку в коллекцию (ArrayList<Item>) заявок items.
     * Устанавливает уникальный ключ в объект Item item с помощью метода setId.
     * Добавляет item в коллекцию (ArrayList<Item>).
     */

    public Item add(Item item) {
        item.setId(ids++);
        this.items.add(item);
        return item;
    }

    /**
     * Возвращает все заявки из коллекции (ArrayList<Item>).
     * Создает коллекцию (ArrayList<Item>) result для хранения найденных заявок.
     * Итерируется по коллекции (ArrayList<Item>) items и добавляет ненулевые заявки в result.
     */
    public List<Item> findAll() {
        return new ArrayList<>(this.items);
    }

    /**
     * Возвращает заявки с заданным именем.
     * Создает новую коллекцию (ArrayList<Item>) result для хранения найденных заявок.
     * Итерируется по коллекции (ArrayList<Item>) items и добавляет заявки с именем,
     * соответствующим key, в result.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Возвращает заявку по заданному идентификатору.
     * Ищет индекс заявки с заданным id с помощью метода indexOf.
     * Возвращает заявку по найденному индексу или null, если заявка не найдена.
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Возвращает индекс заявки по заданному идентификатору.
     * Ищет индекс заявки с заданным id в коллекции ArrayList<Item>.
     * Возвращает индекс найденной заявки или -1, если заявка не найдена.
     */
    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * Заменяет заявку с заданным идентификатором на новую заявку.
     * Сначала производим валидацию входящих параметров (корректный index). Если верно, то...
     * 1. Найти индекс ячейки по id.
     * 2. Проставить id с item. При замене нужно сохранять старый id.
     * 3. Записать в ячейку с найденным индексом объект item. Это входящий параметр.
     * 4. Возвращаем result (он у нас априори true).
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    /**
     * Проверяем "входящие" данные на соответствие параметрам коллекции (ArrayList<Item>)...
     * -> действия с коллекцией (ArrayList<Item>) производим только если "входящие" данные валидны
     * удаляем нужную ячейку...
     * Модель: System.arraycopy(source, startPos, dist, distPos, length);
     * source - коллекция (ArrayList<Item>) ОТКУДА копируем элементы (у нас "items")
     * startPos - стартовая позиция копирования (у нас "index + 1")
     * dist - коллекцию (ArrayList<Item>), КУДА вставить скопированные элементы (можно в тот же массив)
     * (у нас "items" - тот же массив, но можно и другой)
     * distPos - начиная с какого элемента вставлять скопированные ячейки.
     * (у нас "index")
     * length - сколько элементов КОПИРУЕМ начиная от startPos
     * (у нас "items.length - 1 - index")
     */
    public void delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
    }
}
