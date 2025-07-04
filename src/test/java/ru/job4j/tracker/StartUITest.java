package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(new String[]{"33", "0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. ===Завершить программу===" + ln
                        + "Неверный ввод. Выберите значение от 0 до 0" + ln
                        + "Меню: " + ln
                        + "0. ===Завершить программу===" + ln
                        + "===Завершить программу===" + ln
                        + "Завершение программы" + ln
        );
    }

    @Test
    void whenCreatItem() {
        Output output = new StubOutput();
        Input input = new MockInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item")); /* Добавляется в tracker новая заявка */
        String replacedName = "New item name";
        Input input = new MockInput(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"});
        UserAction[] actions = {new ReplaceAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
        Input input = new MockInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(new String[]{"0", String.valueOf(one.getId()), replaceName, "1"});
        UserAction[] actions = new UserAction[]{new ReplaceAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. ===Изменение заявки===" + ln
                        + "1. ===Завершить программу===" + ln
                        + "===Изменение заявки===" + ln
                        + "Заявка изменена успешно" + ln
                        + "Меню: " + ln
                        + "0. ===Изменение заявки===" + ln
                        + "1. ===Завершить программу===" + ln
                        + "===Завершить программу===" + ln
                        + "Завершение программы" + ln);
    }

    @Test
    void whenFindAllItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test3"));
        Input input = new MockInput(new String[]{"0", String.valueOf(one.getId()), "1"});
        UserAction[] actions = new UserAction[]{new FindAllAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. ===Вывод всех заявок===" + ln
                        + "1. ===Завершить программу===" + ln
                        + "===Вывод всех заявок===" + ln
                        + one + ln
                        + two + ln
                        + three + ln
                        + "Меню: " + ln
                        + "0. ===Вывод всех заявок===" + ln
                        + "1. ===Завершить программу===" + ln
                        + "===Завершить программу===" + ln
                        + "Завершение программы" + ln);
    }

    @Test
    void whenFindByNameItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));

        Input input = new MockInput(new String[]{"0", one.getName(), "1"});
        UserAction[] actions = new UserAction[]{new FindByNameAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. ===Поиск заявки по имени===" + ln
                        + "1. ===Завершить программу===" + ln
                        + "===Поиск заявки по имени===" + ln
                        + one + ln
                        + "Меню: " + ln
                        + "0. ===Поиск заявки по имени===" + ln
                        + "1. ===Завершить программу===" + ln
                        + "===Завершить программу===" + ln
                        + "Завершение программы" + ln);
    }

    @Test
    void whenFindByIdItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));

        Input input = new MockInput(new String[]{"0", String.valueOf(one.getId()), "1"});
        UserAction[] actions = new UserAction[]{new FindByIdAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню: " + ln
                        + "0. ===Поиск заявки по ID===" + ln
                        + "1. ===Завершить программу===" + ln
                        + "===Поиск заявки по ID===" + ln
                        + one + ln
                        + "Меню: " + ln
                        + "0. ===Поиск заявки по ID===" + ln
                        + "1. ===Завершить программу===" + ln
                        + "===Завершить программу===" + ln
                        + "Завершение программы" + ln);
    }
}
