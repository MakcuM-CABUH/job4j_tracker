package ru.job4j.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    /*
    Метод должен взять из очереди evenElements только четные символы
    и все их собрать в результирующую строку.
    Для реализации понадобится цикл fori, строку формируйте с помощью StringBuilder.
    Эта очередь всегда имеет четное число элементов
     */
    private String getEvenElements() {
        StringBuilder evenElementsSB = new StringBuilder();
        Deque<Character> evenChars = new ArrayDeque<>(evenElements);
        for (int i = 0; i < evenElements.size(); i++) {
            Character element = evenChars.pollFirst();
            if (i % 2 == 0) {
                evenElementsSB.append(element);
            }
        }
        return evenElementsSB.toString();
    }

    /*
    Метод должен брать символы начиная с последнего символа пока не заберет их все.
    Каждый символ добавляем в результирующую строку, формируем с помощью StringBuilder
     */
    private String getDescendingElements() {
        StringBuilder descendingElementsSB = new StringBuilder();
        Deque<Character> descendingChars = new ArrayDeque<>(descendingElements);
        for (int i = descendingElements.size() - 1; i >= 0; i--) {
            Character element = descendingChars.pollLast();
            descendingElementsSB.append(element);
        }
        return descendingElementsSB.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
