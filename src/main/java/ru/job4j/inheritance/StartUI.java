package ru.job4j.inheritance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {

        Item item = new Item();

        System.out.println("Текущее дата и время без форматирования: " + item.getCreated());
        System.out.println("Текущее дата и время после форматирования: " + item.getFormattedCreatedDate());
    }
}
