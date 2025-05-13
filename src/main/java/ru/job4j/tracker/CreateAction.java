package ru.job4j.tracker;

public class CreateAction implements UserAction {

    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "===Создание новой заявки===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Создание новой заявки ===");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Добавлена заявка: " + item);
        return true;
    }
}
