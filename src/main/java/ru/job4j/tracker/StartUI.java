package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {

        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Выберите номер пункта в меню. ");

            if (select == 0) {
                System.out.println("=== Создание новой заявки ===");
                String name = input.askStr("Введите имя: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("===Вывод всех заявок===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("===Edit item (Изменение заявки)===");
                int id = input.askInt("Enter ID: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно");
                } else {
                    System.out.println("Ошибка замены заявки");
                }
            } else if (select == 3) {
                System.out.println("===Delete item (Удаление заявки)===");
                int id = input.askInt("Enter ID: ");
                Item item = tracker.findById(id);
                tracker.delete(id);
                System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
            } else if (select == 4) {
                System.out.println("===Поиск заявки по ID)===");
                int id = input.askInt("Enter ID: ");
                Item item = tracker.findById(id);
                System.out.println(item != null ? item : "Ошибка поиска заявки.");
            } else if (select == 5) {
                System.out.println("===Поиск заявки по имени)===");
                String name = input.askStr("Enter NAME: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Ошибка поиска. Заявка с именем \"" + name + "\" не найдена");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени",
                "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
