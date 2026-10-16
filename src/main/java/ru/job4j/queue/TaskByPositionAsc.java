package ru.job4j.queue;

import java.util.Comparator;

public class TaskByPositionAsc implements Comparator<Task> {
    /*
    сортирует по полю position по возрастанию, у Enum уже реализован метод compareTo() – именно это и используйте.
     */
    @Override
    public int compare(Task o1, Task o2) {
        return o1.position().compareTo(o2.position());
    }
}
