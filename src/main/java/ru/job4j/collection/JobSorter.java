package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        System.out.println("список без сортировки: \n" + jobs);

/*
сортировка по Приоритету - по возрастанию (через класс "JobAscByPriority implements Comparator<Job>")
 */
        jobs.sort(new JobAscByPriority());
        System.out.println("сортировка по Приоритету (по возрастанию): \n" + jobs);

/*
сортировка по Приоритету - по убыванию (через класс "JobDescByPriority implements Comparator<Job>")
 */
        jobs.sort(new JobDescByPriority());
        System.out.println("сортировка по Приоритету (по убыванию): \n" + jobs);

/*
сортировка по Имени - по возрастанию (через класс "JobAscByName implements Comparator<Job>")
 */
        jobs.sort(new JobAscByName());
        System.out.println("сортировка по Имени (по возрастанию): \n" + jobs);

/*
сортировка по Имени - по убыванию (через класс "JobDescByName implements Comparator<Job>")
 */
        jobs.sort(new JobDescByName());
        System.out.println("сортировка по Имени (по убыванию): \n" + jobs);

/*
Комбинированный: сортировка по Имени (по убыванию) + по Приоритету (по убыванию)
 */
        jobs.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println("сортировка по Имени (по убыванию) + по Приоритету (по убыванию): \n" + jobs);

/*
Комбинированный: сортировка по Длине Имени (по убыванию) + по Имени (по убыванию) + по Приоритету (по убыванию)
 */
        Comparator<Job> combine = new JobDescByNameLength()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobDescByPriority());
        jobs.sort(combine);
        System.out.println("сортировка по Длине Имени (по убыванию) + по Имени (по убыванию) + по Приоритету (по убыванию): \n" + jobs);
    }
}
