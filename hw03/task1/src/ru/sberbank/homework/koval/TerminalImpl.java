package ru.sberbank.homework.koval;

import ru.sberbank.homework.koval.exceptions.TerminalOperationException;

public class TerminalImpl implements Terminal {
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = server.getValidator();
    // private final PinValidator pinValidator = server.getValidator("");

    static final String MESSAGE_WRONG_AMOUNT_OF_MONEY = "Введена недопустимая сумма! " +
            "Сумма должна быть кратна 100. Проведите операцию снова.";

    public boolean validatePin(String pin) {
        pinValidator.validatePin(pin);
        return pinValidator.isValid();
    }

    public int getBalance() {
        int res = server.getBalance(pinValidator);
        return res;
    }

    public void putMoney(int amount) {
        if (amount % 100 != 0) {
            throw new TerminalOperationException(MESSAGE_WRONG_AMOUNT_OF_MONEY);
        }
        server.putMoney(amount, pinValidator);
        // message
    }

    public void receiveMoney(int amount) {
        if (amount % 100 != 0) {
            throw new TerminalOperationException(MESSAGE_WRONG_AMOUNT_OF_MONEY);
        }
        server.receiveMoney(amount, pinValidator);
        // message
    }
}
