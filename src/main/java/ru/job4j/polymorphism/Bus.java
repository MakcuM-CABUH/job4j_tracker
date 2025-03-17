package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Разгон и торможение плавные. Максимальная скорость 80 км/ч");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Пассажирских мест: " + count);
    }

    @Override
    public int refuel(int fuel) {
        fuel = 4000;
        return fuel;
    }
}
