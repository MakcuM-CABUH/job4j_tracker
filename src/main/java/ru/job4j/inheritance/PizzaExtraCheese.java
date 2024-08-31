package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {

    private static final String EXTRA_CHEESE = " with extra cheese";

    public PizzaExtraCheese(String name) {
        super();
    }

    public String name() {
        return super.name() + EXTRA_CHEESE;
    }
}
