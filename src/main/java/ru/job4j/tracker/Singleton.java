package ru.job4j.tracker;

public final class Singleton {

    /**
     * ссылка на единственный объект класса Singleton
     */
    private static Singleton instance = null;

    /**
     * <- явно создаем закрытый конструктор.
     */
    private Singleton() {
    }

    /**
     * <- статический метод. Он используется для публикации ссылки.
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
