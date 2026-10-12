package ru.job4j.collection;

import java.util.Comparator;

/**
 * Ваша задача дописать компаратор, чтобы он сравнивал начальный номер.
 * Примечание.
 * 1. В решении нас интересует шаблон номера задачи, который представлен в тесте выше, т.е., без вложенных номеров задач.
 * Таким образом, тесты дописывать не нужно, для проверки реализованного метода можно использовать тест выше.
 * 2. Для реализации Вам понадобятся следующие методы:
 * - метод split() класса String - необходим для того, чтобы отделить часть строки, которая будет содержать номер задачи;
 * - метод Integer.parseInt() - позволит преобразовать строку, содержащую номер задачи в число типа Integer;
 * - метод Integer.compare() - позволит корректно сравнить номера задач.
 * Задание
 * Реализуйте компаратор LexSort. Он должен сравнивать номер, а не целиком строку.
 */

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int num1 = extractNumber(left);
        int num2 = extractNumber(right);
        return Integer.compare(num1, num2);
    }

    private int extractNumber(String s) {
        StringBuilder numberBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                numberBuilder.append(currentChar);
            } else {
                break;
            }
        }
        return Integer.parseInt(numberBuilder.toString());
    }
}
