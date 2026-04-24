package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * Поле Map содержит всех пользователей системы с привязанными к ним счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод addUser должен добавить пользователя в систему.
     * Чтобы добавить пользователя в систему, можно использовать метод Map.put.
     * Этот метод принимает один параметр: пользователя, т.е. Объект класса User.
     * По умолчанию к этому user нужно добавить пустой список - new ArrayList<Account>().
     * В методе должна быть проверка, что такого пользователя еще нет в системе.
     * Если он есть, то нового добавлять не надо.
     * Обратите внимание на рекомендацию ниже по поводу использования метода putIfAbsent.
     *
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод deleteUser позволит удалить пользователя из системы.
     * Согласно переопределенному equals и hashcode у User, их сравнение происходит по полю passport.
     * Используйте эту важную особенность. Для удаления понадобится метод remove по ключу (вернет объект).
     *
     * @param passport
     */
    public void deleteUser(String passport) {
        User userToDelete = findByPassport(passport);
        if (userToDelete != null) {
            users.remove(userToDelete);
        }
    }

    /**
     * Метод addAccount должен добавить новый счет к пользователю.
     * Пользователя нужно найти по паспорту, используя метод findByPassport.
     * После этого получим список всех счетов пользователя и добавим новый счет к ним.
     * В этом методе должна быть проверка, что такого счета у пользователя еще нет.
     *
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (accounts != null && !accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод findByPassport ищет пользователя по номеру паспорта.
     * Нужно использовать перебор всех элементов через цикл for-each и метод Map.keySet.
     * Если ничего не найдено, метод должен вернуть null.
     *
     * @param passport
     * @return
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport != null && passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод findByRequisite ищет счет пользователя по реквизитам.
     * Нужно найти пользователя по паспорту с помощью метода findByPassport.
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
     * Поскольку метод findByPassport может вернуть null, то прежде чем получать список аккаунтов,
     * требуется проверить что метод findByPassport вернул отличное от null значение.
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
                if (requisite != null && requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод transferMoney предназначен для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте sourcePassport (с которого переводят), то метод должен вернуть false.
     * !!  Посмотрите на методы Map.putIfAbsent и List.contains, как их можно применить в этом задании?
     * Метод putIfAbsent позволяет проверить, если ли такой ключ в карте или нет и если его нет, то произвести вставку данных.
     * Этот метод позволяет уменьшить количество кода.
     * Метод List.contains позволяет проверить содержит ли наш список элемент,
     * который мы передаем в качестве аргумента в этот метод. При этом метод возвращает true,
     * когда в списке такой элемент присутствует, а иначе метод вернет false.
     * Для корректной работы этого метода для модели данных,
     * объекты которой хранятся в этом списке должны быть переопределены методы equals() и hashcode().
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
            // 4. Выполняем перевод
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
