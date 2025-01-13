package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        String text = new String();
        if (answer == 0) {
            text = "Да!";
        } else if (answer == 1) {
            text = "Нет!";
        } else {
            text = "Всё может быть...";
        }
        System.out.println("На вопрос: \"" + question + "\"" + ", ответ однозначный! " + text);
    }
}
