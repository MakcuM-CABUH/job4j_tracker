package ru.job4j.polymorphism;

public interface Vehicle extends Fuel {

    int WHEELS = 4;

    void accelerate();

    void brake();

    void steer();

    void changeGear();

    void refill();

    static void getDragCoefficient() {
        System.out.println("Формула рассчёта коэффициента аэродинамического сопротивления автомобиля");
    }

    default void chargeBattery() {
        System.out.println("Аккомулятор под капотом. Зарядить");
    }
}
