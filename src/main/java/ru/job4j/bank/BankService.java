package ru.job4j.bank;

import java.util.*;

/**
 * Данный класс описывает работу простейшей банковской системы
 * @author Dmitrii Dobrydin
 * @version 1.0
 */
public class BankService {
    /**
     * Данная карта содержит список пользователей, ключом является
     * объект класса User, второй параметр - список счетов пользователя
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Данный метод добавляет пользователя в банковскую систему
     * @param user - пользователь, который мы хотем добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Данный метод удаляет пользователя из банковской системы
     * @param passport - номер пасспорта пользователя,
     * оторого мы хотим удалить
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Данный метод добавляет новый счет пользователю
     * @param passport - пасспорт пользователя
     * @param account - счет, который мы хотим добавить
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
     * Данный метод исчет пользователя по пасспорту
     * @param passport - пасспорт пользователя,
     * которого мы ищем.
     * @return - возвращает пользователя, если он не найден, то null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Данный метод исчет пользователя по реквизитам
     * @param passport - пасспорт пользователя
     * @param requisite - реквизиты пользователя
     * @return возвращает счет пользователя, либо null,
     * если пользователь не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        return users.get(user)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Данный метод реализует перевод денег от одного пользователя к другому
     * @param srcPassport - номер пасспорта отправителя
     * @param srcRequisite - реквизиты счета отправителя
     * @param destPassport - номер паспорта получателя
     * @param destRequisite - реквизиты получателя
     * @param amount - количество переводимых денег
     * @return возвращает true, если перевод успешен, false, если неуспешен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null  && src.getBalance() >= amount && dest != null) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * @param user - пользователь, чьи счета мы хотим получить
     * @return - Метод возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
