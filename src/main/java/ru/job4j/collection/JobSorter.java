package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Reboot server", 1),
                new Job("Impl task", 2)
        );
        System.out.println(jobs);
/*
сортировка по Приоритету
 */
        Collections.sort(jobs);
        System.out.println(jobs);
/*
сортировка по Имени - по возрастанию (через класс "SortByNameJob implements Comparator<Job>")
 */
        Collections.sort(jobs, new SortByNameJob());
        System.out.println(jobs);
/*
сортировка по Имени - по убыванию (через класс "SortDescByNameJob implements Comparator<Job>")
 */
        jobs.sort(new SortDescByNameJob());
        System.out.println(jobs);
    }
}
