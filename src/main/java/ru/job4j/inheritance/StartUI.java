package ru.job4j.inheritance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {

        Item item = new Item();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"dd-MMMM-EEEE-yyyy HH:mm:ss\"");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println("Текущее дата и время: " + currentDateTimeFormat);
    }
}
