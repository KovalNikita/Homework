package ru.sberbank.homework.koval;

import ru.sberbank.homework.koval.exceptions.*;
import ru.sberbank.homework.koval.logger.ConsoleLogger;
import ru.sberbank.homework.koval.logger.Logger;

import java.util.Scanner;

public class Application {

    static final String MESSAGE_WRONG_OPERATION_ERROR =
            "Введена недопустимая операция! Попробуйте снова.";
    static final String MESSAGE_PIN_INPUT = "Введите пин:";
    static final String MESSAGE_WRONG_PIN = "Неверный пин! Попробуйте снова.";
    static final String MESSAGE_CHOOSE_OPERATION = "Выберите операцию: b (проверить баланс)," +
            " p (пополнить баланс) или r(снять деньги): ";
    static final String MESSAGE_CHOOSE_AMOUNT_OF_MONEY = "Выберите сумму: ";
    static final String MESSAGE_SUCCESS = "Операция выполнена успешно!";
    static final String MESSAGE_CURRENT_BALANCE = "Текущий баланс: ";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Terminal t = new TerminalImpl();
        Logger log = new ConsoleLogger();

        String input;
        while (true) {
            log.sendMessage(MESSAGE_PIN_INPUT);
            input = scanner.nextLine();
            if (input.equals("quit")) {
                return;
            }
            try {
                if (t.validatePin(input)) {
                    break;
                }
                log.sendMessage(MESSAGE_WRONG_PIN);
            } catch (AccountIsLockedException e) {
                log.sendMessage(e.getMessage());
            }
        }

        while (true) {
            log.sendMessage(MESSAGE_CHOOSE_OPERATION);
            input = scanner.nextLine();
            try {
                if (input.equals("quit")) {
                    return;
                }
                if (input.length() != 1) {
                    throw new TerminalOperationException(MESSAGE_WRONG_OPERATION_ERROR);
                }
                String moneyStr;
                int n;
                switch (input.charAt(0)) {
                    case 'b':
                        n = t.getBalance();
                        log.sendMessage(MESSAGE_CURRENT_BALANCE + n);
                        break;
                    case 'p':
                        log.sendMessage(MESSAGE_CHOOSE_AMOUNT_OF_MONEY);
                        moneyStr = scanner.nextLine();
                        n = Integer.parseInt(moneyStr, 10); //t.getBalance();
                        t.putMoney(n);
                        log.sendMessage(MESSAGE_SUCCESS);
                        break;
                    case 'r':
                        log.sendMessage(MESSAGE_CHOOSE_AMOUNT_OF_MONEY);
                        moneyStr = scanner.nextLine();
                        n = Integer.parseInt(moneyStr, 10); //t.getBalance();
                        t.receiveMoney(n);
                        log.sendMessage(MESSAGE_SUCCESS);
                        break;
                    default:
                        throw new TerminalOperationException(MESSAGE_WRONG_OPERATION_ERROR);
                }
            } catch (AccountAccessException |
                    AccountIsLockedException |
                    ServerAccessException |
                    TerminalOperationException e) {
                log.sendMessage(e.getMessage());
            }
        }
    }
}
