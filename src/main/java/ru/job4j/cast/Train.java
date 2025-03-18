package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд: Движется только о рельсам");
    }

    @Override
    public void capacity() {
        System.out.println("Поезд: Перевозит тысячи пассажиров. Поездка комфортная, но медленная");
    }
}