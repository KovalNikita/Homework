package ru.sberbank.homework.koval;

import ru.sberbank.homework.koval.exceptions.AccountIsLockedException;

public class PinValidator {

    private String pin;

    static final int TIME_OUT = 5000;
    static final String MESSAGE_ACCAUNT_IS_LOCKED = "Пин введен неправильно более трех раз. Аккаунт временно " +
            "заблокирован. Попробуйте выполнить операцию через несколько секунд";

    private long lastLockTime;
    private boolean isLocked;
    private int numOfRequests;

    private boolean isValid;


    public PinValidator(String pin) {
        this.pin = pin;
        this.numOfRequests = 0;
        this.isLocked = false;
    }

    public void validatePin(String pin) {
        if (isLocked) {
            if (System.currentTimeMillis() - lastLockTime > TIME_OUT) {
                isLocked = false;
                numOfRequests = 0;
            } else {
                throw new AccountIsLockedException(MESSAGE_ACCAUNT_IS_LOCKED);
            }
        }
        isValid = this.pin.equals(pin);
        if (!isValid) {
            ++numOfRequests;
            if (numOfRequests >= 3) {
                isLocked = true;
                lastLockTime = System.currentTimeMillis();
            }
        } else {
            numOfRequests = 0;
        }
        //return isValid;
    }

    boolean isValid() {
        return isValid;
    }
}
