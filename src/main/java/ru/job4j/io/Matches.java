package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру \"11\"");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Игрок №1" : "Игрок №2";
            System.out.println(player + ": введите число от 1 до 3.");
            int matches = Integer.parseInt(input.nextLine());

            if (matches >= 1 && matches <= 3 && matches <= count) {
                count -= matches;
                System.out.println("Осталось " + count + " спичек.");
                turn = !turn;
            } else {
                System.out.println(player + ", вы ввели неверное значение. Попробуйте ещё раз. Наберите число от 1 до 3-х (но не больше, чем осталось спичек на столе)");
            }

        }
        if (!turn) {
            System.out.println("Выиграл Игрок №1!");
        } else {
            System.out.println("Выиграл Игрок №2!");
        }
    }
}
