package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолёт: Летает по воздуху");
    }

    @Override
    public void capacity() {
        System.out.println("Самолёт: Вмещает до 150-пассажиров. Перевозит их очень быстро на дальние расстояния");
    }
}