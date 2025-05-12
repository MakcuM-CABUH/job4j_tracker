package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "===Поиск заявки по ID===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        System.out.println(item != null ? item : "Ошибка поиска заявки.");
        return true;
    }
}
