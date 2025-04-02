package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("===Creat a new item===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавлена заявка: " + item);
    }

    public void init(Input input, Tracker tracker) {

        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Выберите номер пункта в меню. ");

            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("===Поиск заявки по ID)===");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        System.out.println(item != null ? item : "Ошибка поиска заявки.");
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("===Delete item (Удаление заявки)===");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("===Edit item (Изменение заявки)===");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно");
        } else {
            System.out.println("Ошибка замены заявки");
        }
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("===Вывод всех заявок===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
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
        StartUI.createItem(input, tracker);
    }
        /*
    формальная правка
     */
}