package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс представляет собой сервис для управления банковскими пользователями и их счетами.
 * Он связывает объекты User (пользователь) с их списками объектов Account (счет) и позволяет выполнять финансовые операции.
 * В основе класса лежит поле private final Map<User, List<Account>> users (хэш-таблица).
 * <p>
 * Архитектурные недостатки и риски:
 * Поиск по паспорту: Итерация по keySet() делает поиск пользователя медленным при росте базы.
 * Целостность данных: Прямой доступ к балансу через setBalance (из класса Account) и отсутствие транзакционности
 * в transferMoney создают риски потери денег или некорректного состояния счетов.
 * Точность вычислений: Использование double для денег гарантированно приведет к ошибкам округления.
 * Инкапсуляция: Метод getAccounts отдает ссылку на внутреннее состояние, позволяя менять его извне.
 * Жесткая связь (Tight coupling): Сервис напрямую зависит от реализации User и Account.
 * Если в этих классах изменятся правила сравнения в equals, поведение HashMap и списков может сломаться.
 */
public class BankService {
    /**
     * Хэш-таблица, где:
     * Ключ — объект User.
     * Значение — список (ArrayList) объектов Account, принадлежащих этому пользователю.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в систему.
     * Метод putIfAbsent гарантирует, что если пользователь с таким же ключом
     * (согласно его методу equals) уже есть в карте, новый список создаваться не будет.
     *
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя. Здесь создается временный объект new User(passport, "").
     *
     * @param passport
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет счет конкретному пользователю.
     * Сначала метод находит объект User по строке паспорта через findByPassport().
     * Затем он получает список счетов этого пользователя и добавляет новый счет,
     * только если его еще нет в списке (проверка через accounts.contains(account))
     *
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Ищет пользователя по номеру паспорта. Метод итерируется по всем ключам (keySet()) карты.
     *
     * @param passport
     * @return
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Ищет конкретный счет.
     * Сначала находит пользователя, затем получает его список счетов и перебирает его в цикле,
     * пока не найдет совпадение по реквизиту.
     *
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Выполняет перевод средств.
     * Метод находит счета отправителя и получателя.
     * Если оба счета найдены и на счету отправителя достаточно средств (getBalance() >= amount),
     * происходит списание с одного счета и зачисление на другой.
     *
     * @param sourcePassport
     * @param sourceRequisite
     * @param destinationPassport
     * @param destinationRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (sourceAccount != null && destAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Возвращает список счетов пользователя.
     *
     * @param user
     * @return
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
