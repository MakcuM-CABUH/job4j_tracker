package ru.job4j.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleTask {
    private PriorityQueue<Task> queue;

    /*
    - addTask() просто добавляет переданную задачу в очередь;
    - readTask() просто читает элемент из головы очереди без удаления;
    - getTask() возвращает задачу из головы очереди с удалением.
    Если очередь пуста – реализация не должна генерировать исключений.
     */
    public ScheduleTask(Comparator<Task> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }

    public void addTask(Task task) {
        if (task != null) {
            queue.offer(task);
        }
    }

    public Task readTask() {
        return queue.peek();
    }

    public Task getTask() {
        return queue.poll();
    }
}
