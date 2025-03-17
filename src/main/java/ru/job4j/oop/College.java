package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        /*
        приведение объекта Freshman к Student, а потом к Object.
         Ответьте на вопрос к какому типу приведения это относится?
         Такое приведение типов называется повышающим (up casting). Мы приводим конкретный тип Freshman к более общему типу данных Student
         */
        /*
        создаём объект класса Freshman
         */
        Freshman freshman = new Freshman();
        /*
        делаем приведение к типу родителя Student.
         */
        Student student = freshman;
        /*
        делаем приведение к типу родителя Object.
         */
        Object object = freshman;
    }
}
