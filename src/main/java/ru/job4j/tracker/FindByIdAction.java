package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "===Поиск заявки по ID===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("===Поиск заявки по ID===");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        output.println(item != null ? item : "Ошибка поиска заявки.");
        return true;
    }
}
