package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс предназначен для хранения данных о человеке в банковской системе,
 * где главным идентификатором выступает серия и номер паспорта.
 */
public class User {
    /**
     * Строковые поля: passport и username. Конструктор инициализирует их при создании объекта.
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределённый метод equals() проверяет равенство двух пользователей.
     * Логика сравнения строится исключительно по полю passport.
     * Если у двух объектов совпадает серия и номер паспорта, Java считает их абсолютно одинаковыми,
     * даже если у них разные имена (username).
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределённый метод hashCode() возвращает хэш-код, вычисленный только на основе passport.
     * Это строго соответствует контракту Java: если equals() возвращает true, то и hashCode() у этих объектов обязан быть одинаковым.
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}