package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {

        System.out.println("Пошёл колобок погулять.");

        boolean condition = false;

        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        hare.tryEat(ball);
        System.out.println("Ему встретился Заяц. Колобок запел ему песенку. Заяц заслушался. Колобок побежал дальше.");
        wolf.tryEat(ball);
        System.out.println("Ему встретился Волк. Колобок запел ему песенку. Волк заслушался. Колобок побежал дальше.");
        fox.tryEat(ball);
        System.out.println("Ему встретилась Лиса. Колобок ей тоже запел песенку. Но Лиса съела Колобка. Конец сказки");
    }
}
