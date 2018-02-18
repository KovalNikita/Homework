package ru.sberbank.homework.koval_nikita;

import ru.sberbank.homework.koval_nikita.ExpressionFormatException;

public class SimpleParser {
    private static String deleteUnderlining(String number) {
        int len = number.length();
        if (len == 0) {
            throw new NumberFormatException();
        }
        if (number.charAt(0) != '_' &&
                number.charAt(len - 1) != '_') {
            return number.replace("_", "");
        }
        throw new NumberFormatException();
    }

    private static double parseInt(String number) {

        int len = number.length();
        if (len == 0) {
            throw new ExpressionFormatException();
        }

        int radix;
        if (number.charAt(0) == '0') {
            if (len == 1) {
                return 0;
            } else {
                switch (number.charAt(1)) {
                    case 'x':
                        radix = 16;
                        number = number.substring(2);
                        break;
                    case 'b':
                        radix = 2;
                        number = number.substring(2);
                        break;
                    default:
                        radix = 8;
                        number = number.substring(1);
                }
            }
        } else {
            radix = 10;
        }

        return Integer.parseInt(deleteUnderlining(number), radix);
    }

    private static double parseDouble(String number) {
        String[] parts = number.split("\\.");
        if (parts.length != 2) {
            throw new NumberFormatException();
        }
        String intPart = parts[0];
        String fractPart = parts[1];
        if (intPart.length() != 0) {
            intPart = deleteUnderlining(intPart);
        }
        fractPart = deleteUnderlining(fractPart);
        return Double.parseDouble(intPart + "." + fractPart);
    }

    static public double parse(String number) {

        String lowCaseNumber = number.toLowerCase();
        int len = number.length();
        double res;
        try {
            if (!number.contains(".")) {
                if (lowCaseNumber.charAt(len - 1) == 'l') {
                    lowCaseNumber = lowCaseNumber.substring(0, len - 1);
                }
                res = parseInt(lowCaseNumber);
            } else {
                res = parseDouble(lowCaseNumber);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(number);
        }
        return res;

    }
}
