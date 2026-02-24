package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
метод - извлекает все номера задач и убирает дубликаты
      - создает множество HashSet для хранения уникальных номеров задач "extractNumberHash"
      - итерирует по списку задач и добавляет каждый номер задачи в множество
 */
public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        HashSet<String> extractNumberHash = new HashSet<>();
        for (Task task : tasks) {
            extractNumberHash.add(task.getNumber());
        }
        return extractNumberHash;
    }
}
