package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition) {
        if (!condition) {
            System.out.println("Ему встретился Заяц. Колобок запел ему песенку. Заяц заслушался. Колобок побежал дальше.");
        } else {
            System.out.println("Ему встретилась Лиса. Колобок ей тоже запел песенку. Но Лиса съела Колобка. Конец сказки");
        }
    }
}