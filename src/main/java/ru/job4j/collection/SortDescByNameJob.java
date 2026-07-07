package ru.job4j.collection;

import java.util.Comparator;

public class SortDescByNameJob implements Comparator<Job> {
    /*
    Компаратор - сортировка списка Jobs по имени (по убыванию) - просто поменяли местами "left" и "right".
     */
    @Override
    public int compare(Job left, Job right) {
        return right.getName().compareTo(left.getName());
    }
}
