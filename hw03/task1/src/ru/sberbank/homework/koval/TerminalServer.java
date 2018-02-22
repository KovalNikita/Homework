package ru.sberbank.homework.koval;

import ru.sberbank.homework.koval.exceptions.AccountAccessException;
import ru.sberbank.homework.koval.exceptions.ServerAccessException;

public class TerminalServer {

    static final String MESSAGE_ACCESS_ERROR = "Ошибка аутентификации. Введите пин!";
    static final String MESSAGE_NOT_ENOUGTH_MONEY = "На счету недостаточно средств! Выберите другую сумму";
    static final String MESSAGE_SERVER_ERROR = "Сервер временно недосупен. Попробуйте выполнить операцию позже";

    int balance = 3000;
    String pin = "1234";
    public TerminalServer() {
    }

    public PinValidator getValidator() {
        return new PinValidator(this.pin);
    }

    int getBalance(PinValidator val) {
        if(!val.isValid()) {
            throw new AccountAccessException(MESSAGE_ACCESS_ERROR);
        }
        return this.balance;
    }

    void putMoney(int amount, PinValidator val) {
        if(!val.isValid()) {
            throw new AccountAccessException(MESSAGE_ACCESS_ERROR);
        }
        this.balance += amount;
    }

    void receiveMoney(int amount, PinValidator val) {
        if(!val.isValid()) {
            throw new AccountAccessException(MESSAGE_ACCESS_ERROR);
        }

        if (amount > this.balance) {
            throw new ServerAccessException(MESSAGE_NOT_ENOUGTH_MONEY); /////////////////
        }
        this.balance -= amount;
    }
}
