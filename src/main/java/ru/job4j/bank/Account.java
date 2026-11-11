package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс Account представляет собой простую модель банковского счета.
 */
public class Account {
    /**
     * Уникальный идентификатор счета (например, номер счета или IBAN).
     */
    private String requisite;
    /**
     * Вещественное число (double), хранящее сумму денег на счете.
     */
    private double balance;

    /**
     * Конструктор: public Account(String requisite, double balance) создает новый объект,
     * инициализируя его идентификатор и начальный баланс.
     *
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределённый метод определяет логику сравнения двух объектов Account.
     * <p>
     * Сначала проверяется ссылка: если сравнивается объект сам с собой, возвращается true.
     * Затем проверяется на null и совпадение типов.
     * В ядре метода происходит приведение типа и сравнение только по полю requisite с помощью Objects.equals().
     * Это означает, что два счета считаются абсолютно одинаковыми (одним и тем же логическим объектом),
     * если у них совпадает реквизит. Значение баланса при сравнении полностью игнорируется.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение hashCode().
     * Согласно контракту Java, если переопределен метод equals(), обязательно должен быть переопределен и hashCode().
     * Здесь хэш-код вычисляется только на основе поля requisite.
     * Это гарантирует, что два объекта, которые equals() считает равными, будут иметь одинаковый хэш-код.
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
