package ru.job4j.collection;

import java.util.Comparator;

/**
 * Задача! Нельзя использовать метод String.compareTo
 * Нужно реализовать компаратор для сравнения двух массивов символов
 * (внутри класс String хранит данные в виде массива).
 * Необходимо реализовать поэлементное сравнение двух строк, т.е., сравниваем элементы двух строк,
 * находящихся на одних и тех же позициях (под одним и тем же индексом).
 * Для извлечения символа из строки по индексу понадобится
 * использовать метод charAt(int index). Сравнение в лексикографическом порядке.
 * ++
 * 1. Реализуйте класс: "ru.job4j.collection. StringCompare"
 * Вам необходимо использовать методы:
 * String.charAt(int index)
 * Integer.compare(int left, int right),
 * Character.compare(char left, char right);
 * 2. Добавьте недостающие тесты.
 */
public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        if (left == null && right == null) {
            return 0;
        }
        if (left == null) {
            return -1;
        }
        if (right == null) {
            return 1;
        }

        int minLength = Math.min(left.length(), right.length());

        for (int i = 0; i < minLength; i++) {
            int charCompare = Character.compare(left.charAt(i), right.charAt(i));
            if (charCompare != 0) {
                return charCompare;
            }
        }

        return Integer.compare(left.length(), right.length());
    }
}
