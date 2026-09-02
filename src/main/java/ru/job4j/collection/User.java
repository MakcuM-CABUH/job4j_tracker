package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
    Нужно реализовать метод public int compareTo(User o)!!!
    Очень Важно!!! Метод должен сравнивать имена и в случае их равенства,
        метод должен вернуть результат сравнения возраста. Для реализации вам понадобятся
        - метод compareTo(), который определен в классе String для сравнения имен;
        - метод Integer.compare(), который будет необходим для сравнения возрастов.
    В модели User также реализованы методы equals и hashCode.
    Они нужны для тестов, где мы используем методы сравнения моделей user.equals.
     */
    @Override
    public int compareTo(User o) {
        // Сначала сравниваем имена
        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        // Если имена равны, сравниваем возраст
        return Integer.compare(this.age, o.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
