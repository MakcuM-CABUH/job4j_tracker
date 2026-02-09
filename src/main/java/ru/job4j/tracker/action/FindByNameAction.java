package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "===Поиск заявки по имени===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("===Поиск заявки по имени===");
        String name = input.askStr("Enter NAME: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Ошибка поиска. Заявка с именем \"" + name + "\" не найдена");
        }
        return true;
    }
}
