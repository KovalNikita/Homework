package ru.sberbank.homework.koval;

import ru.sberbank.homework.common.Calculator;

import java.text.DecimalFormat;

public class KovalsCalculator implements Calculator {

    private double currResult;
    private boolean isFirstOperation = true;

    public String calculate(String userInput) {

        String[] tokens = userInput.split(" ");

        Operation op;
        double num1;
        double num2;
        String result;
        try {
            switch (tokens.length) {
                case 2:
                    if (isFirstOperation) {
                        throw new ExpressionFormatException();
                    }
                    num1 = currResult;
                    op = Operation.getOperation(tokens[0]);
                    num2 = SimpleParser.parse(tokens[1]);
                    break;
                case 3:
                    num1 = SimpleParser.parse(tokens[0]);
                    op = Operation.getOperation(tokens[1]);
                    num2 = SimpleParser.parse(tokens[2]);
                    break;
                default:
                    throw new ExpressionFormatException();
            }
            currResult = op.apply(num1, num2);
            isFirstOperation = false;
            DecimalFormat df2 = new DecimalFormat("###.##");
            result = df2.format(currResult).replace(",", ".");
        } catch (NumberFormatException e) {
            result = "error > " + e.getMessage();
        } catch (ExpressionFormatException e) {
            result = "error > wrong expression";
        }
        return result;
    }
}
