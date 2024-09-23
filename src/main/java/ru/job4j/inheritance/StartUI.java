package ru.job4j.inheritance;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {

        Item item = new Item();

        System.out.println("Текущее дата и время без форматирования: " + item.getCreated());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = item.getCreated().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + createdFormat);
    }
}
