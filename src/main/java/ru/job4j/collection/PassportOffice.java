package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    /*
    - Сервис проверяет, что гражданина с таким паспортом еще нет,
        а также выдаёт информацию о гражданине по его паспорту.

    - Метод add возвращает true, если пользователя еще нет в HashMap.
     Если он уже есть, то возвращает false.

    - Метод Map.containsKey() проверяет содержит ли Map переданный ключ.
    Метод Map.get(key) ищет гражданина по номеру паспорта.
    Если гражданин найден, он возвращается. Если нет — возвращается null.
     */
    public boolean add(Citizen citizen) {

        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            return true;
        }
        return false;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
