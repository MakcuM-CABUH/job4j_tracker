package ru.job4j.oop;

public class Tamagotchi {
    private int weight = 100;

    public void feed() {
        weight += 10;
    }

    public String info() {
        return "weight: " + weight;
    }

    public static void feedPet(Tamagotchi petCopy) {
        petCopy.feed();
    }

    public static void main(String[] args) {
        Tamagotchi pet = new Tamagotchi();
//        Tamagotchi petCopy = pet;
        System.out.println("weight: " + pet.info());
//        System.out.println("copy of weight: " + petCopy.info());
        feedPet(pet);
//        petCopy.feed();
        System.out.println("weight: " + pet.info());
//        System.out.println("copy of weight: " + petCopy.info());
    }
}
