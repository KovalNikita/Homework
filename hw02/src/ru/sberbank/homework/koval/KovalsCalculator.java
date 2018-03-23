package ru.sberbank.homework.koval;

import ru.sberbank.homework.common.Calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import ru.sberbank.homework.koval.parsers.Parser;

public class KovalsCalculator implements Calculator {
    private static final String WRONG_EXP = "error > wrong expression";

    private double currResult;
    private boolean isFirstOperation = true;
    private DecimalFormat decimalFormat;

    KovalsCalculator() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        String pattern = "###.##";
        decimalFormat = new DecimalFormat(pattern, otherSymbols);
    }

    public String calculate(String userInput) {
        String[] tokens = userInput.split(" ");
        int numOfTokens = tokens.length;
        if (numOfTokens != 2 && numOfTokens != 3) {
            return WRONG_EXP;
        }

        try {
            int tokenIdx = 0;
            double num1;
            if (numOfTokens == 2) {
                if (isFirstOperation) {
                    return WRONG_EXP;
                }
                num1 = currResult;
            } else {
                num1 = Parser.parse(tokens[tokenIdx++]);
            }

            Operation operation = Operation.getOperation(tokens[tokenIdx++]);
            double num2 = Parser.parse(tokens[tokenIdx]);

            currResult = operation.apply(num1, num2);
            isFirstOperation = false;
            return decimalFormat.format(currResult);
        } catch (NumberFormatException e) {
            return "error > " + e.getMessage();
        } catch (ExpressionFormatException e) {
            return WRONG_EXP;
        }
    }
}
