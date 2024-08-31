package ru.job4j.inheritance;

public class Pizza {
    private String name;

    public Pizza() {
        this.name = name();
    }

    public String name() {
        return "Just tasty pizza";
    }
}
