package ru.job4j.collection;

import java.util.Comparator;

public class SortByNameJob implements Comparator<Job> {
    /*
    Компаратор - сортировка списка Jobs по имени (по возрастанию).
     */
    @Override
    public int compare(Job left, Job right) {
        return left.getName().compareTo(right.getName());
    }
}
