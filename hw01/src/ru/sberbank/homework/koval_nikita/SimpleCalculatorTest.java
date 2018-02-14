package ru.sberbank.homework.koval_nikita;

import ru.sberbank.homework.koval_nikita.SimpleCalculator;
import ru.sberbank.homework.koval_nikita.Assert;

public class SimpleCalculatorTest {
    public static void main(String[] args) {

        testIntAddition();
        testIntSubtraction();
        testIntMultiplication();
        testIntDivision();

        testDoubleAddition();
        testDoubleSubtraction();
        testDoubleMultiplication();
        testDoubleDivision();

        System.out.println("All tests were passed successfully!");
    }

    private static void testIntAddition() {
        int actual = SimpleCalculator.Addition(2, 3);
        int expected = 5;
        Assert.assertIntsAreEqual("Error in testIntAddition", expected, actual);
    }

    private static void testIntSubtraction() {
        int actual = SimpleCalculator.Subtraction(21, 8);
        int expected = 13;
        Assert.assertIntsAreEqual("Error in testIntSubtraction", expected, actual);
    }

    private static void testIntMultiplication() {
        int actual = SimpleCalculator.Multiplication(19, 2);
        int expected = 38;
        Assert.assertIntsAreEqual("Error in testIntMultiplication", expected, actual);
    }

    private static void testIntDivision() {
        int actual = SimpleCalculator.Division(14, 6);
        int expected = 2;
        Assert.assertIntsAreEqual("Error in testIntDivision", expected, actual);
    }

    private static void testDoubleAddition() {
        double actual = SimpleCalculator.Addition(8.4, 3.6);
        double expected = 12;
        Assert.assertDoublesAreEqual("Error in testDoubleAddition", expected, actual);
    }

    private static void testDoubleSubtraction() {
        double actual = SimpleCalculator.Subtraction(8.31, 0.2);
        double expected = 8.11;
        Assert.assertDoublesAreEqual("Error in testDoubleSubtraction", expected, actual);
    }

    private static void testDoubleMultiplication() {
        double actual = SimpleCalculator.Multiplication(2.47, 3.4);
        double expected = 8.398;
        Assert.assertDoublesAreEqual("Error in testDoubleMultiplication", expected, actual);
    }

    private static void testDoubleDivision() {
        double actual = SimpleCalculator.Division(9.86, 4.8);
        double expected = 2.0541667;
        Assert.assertDoublesAreEqual("Error in testDoubleDivision", expected, actual);
    }
}
