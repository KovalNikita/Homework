package ru.sberbank.homework.koval.parsers;

import ru.sberbank.homework.koval.ExpressionFormatException;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static boolean isNegative;
    private static List<NumberParser> parsers = Arrays.asList(
            new DoubleParser(),
            new BinIntegerParser(),
            new HexIntegerParser(),
            new OctIntegerParser(),
            new DecIntegerParser()
    );

    private static String deleteSign(String number) {
        if (number.isEmpty()) {
            throw new ExpressionFormatException();
        }
        char first = number.charAt(0);
        isNegative = first == '-';
        if (isNegative || first == '+') {
            return number.substring(1);
        }
        return number;
    }

    public static double parse(String number) {
        String srcNumber = number;
        number = deleteSign(number);
        number = number.toLowerCase();

        try {
            for (NumberParser parser : parsers) {
                if (parser.checkType(number)) {
                    double res = parser.parse(number);
                    return isNegative ? -res : res;
                }
            }
            throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(srcNumber);
        }
    }
}
