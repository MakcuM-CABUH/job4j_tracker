package ru.job4j.tracker;

/**
 * Cоздайте 1 объект класса Item,
 * выведите созданный объект в консоль.
 * Проверьте, что вывод даты созданной заявки в отличие от задачи 8. Date. Отображение даты не изменился.
 */
public class StartUI {

    public static void main(String[] args) {
        Item object1 = new Item(1, "object1");
        System.out.println(object1);
    }
}
