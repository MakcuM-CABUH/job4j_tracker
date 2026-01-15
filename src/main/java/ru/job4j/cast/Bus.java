package ru.job4j.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Автобус: Передвигается по скоростным автодорогам");
    }

    @Override
    public void capacity() {
        System.out.println("Автобус: Вмещает до 30-пассажиров. Перевозит их со средней скоростью");
    }
}