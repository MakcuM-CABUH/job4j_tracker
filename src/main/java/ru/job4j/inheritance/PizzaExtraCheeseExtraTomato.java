package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {

    private static final String EXTRA_TOMATO = " with extra tomato";

    public PizzaExtraCheeseExtraTomato(String name) {
        super(name);
    }

    public String name() {
        return super.name() + EXTRA_TOMATO;
    }
}
