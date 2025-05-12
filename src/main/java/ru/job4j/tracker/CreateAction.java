package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "===Создание новой заявки===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавлена заявка: " + item);
        return true;
    }
}
