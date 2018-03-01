package ru.sberbank.homework.koval;

import ru.sberbank.homework.common.Calculator;

import java.util.Scanner;

public class CalculatorTest {
    private static final String WRONG_MSG = "error > wrong expression";

    public static void main(String[] args) {

        binLiteralsTest();
        octLiteralsTest();
        decLiteralsTest();
        hexLiteralsTest();
        doubleFormatTest();
        wrongCommandTest();

        System.out.println("All tests were passed successfully!");

        Scanner in = new Scanner(System.in);
        Calculator calc = new KovalsCalculator();
        while (true) {
            String input = in.nextLine();
            if (input.equals("quit")) {
                break;
            }
            System.out.println(calc.calculate(input));
        }
        System.out.println();
    }

    private static void binLiteralsTest() {
        Calculator calc = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in binLiteralsTest! Test1", calc.calculate("0b1 + 0B101"), "6");
        Assert.assertStringsAreEqual("Error in binLiteralsTest! Test2", calc.calculate("* 0B101"), "30");
        Assert.assertStringsAreEqual("Error in binLiteralsTest! Test3", calc.calculate("/ 0b1____1"), "10");
        Assert.assertStringsAreEqual("Error in binLiteralsTest! Test4", calc.calculate("+ 0B10_1_"), "error > 0B10_1_");
    }

    private static void octLiteralsTest() {
        Calculator calc = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in octLiteralsTest! Test1", calc.calculate("011 + 0174"), "133");
        Assert.assertStringsAreEqual("Error in octLiteralsTest! Test2", calc.calculate("* 040__3"), "34447");
        Assert.assertStringsAreEqual("Error in octLiteralsTest! Test3", calc.calculate("- 010_1_"), "error > 010_1_");
        Assert.assertStringsAreEqual("Error in octLiteralsTest! Test4", calc.calculate("+ 0_01"), "34448");
    }

    private static void decLiteralsTest() {
        Calculator calc = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in decLiteralsTest! Test1", calc.calculate("101 + 174"), "275");
        Assert.assertStringsAreEqual("Error in decLiteralsTest! Test2", calc.calculate("* 2_"), "error > 2_");
        Assert.assertStringsAreEqual("Error in decLiteralsTest! Test3", calc.calculate("- _1"), "error > _1");
        Assert.assertStringsAreEqual("Error in decLiteralsTest! Test4", calc.calculate("+ 1i"), "error > 1i");
    }

    private static void hexLiteralsTest() {
        Calculator calc = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in hexLiteralsTest! Test1", calc.calculate("0xABC - 0Xbc"), "2560");
        Assert.assertStringsAreEqual("Error in hexLiteralsTest! Test2", calc.calculate("0XF_F + 1"), "256");
        Assert.assertStringsAreEqual("Error in hexLiteralsTest! Test2", calc.calculate("* 0x2_"), "error > 0x2_");
        Assert.assertStringsAreEqual("Error in hexLiteralsTest! Test3", calc.calculate("- 0x_1"), "error > 0x_1");
    }

    private static void doubleFormatTest() {
        Calculator calc = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in doubleFormatTest! Test1", calc.calculate("20 / 3"), "6.67");
        Assert.assertStringsAreEqual("Error in doubleFormatTest! Test2", calc.calculate("16 / 10"), "1.6");
        Assert.assertStringsAreEqual("Error in doubleFormatTest! Test3", calc.calculate("/ 100"), "0.02");
        Assert.assertStringsAreEqual("Error in doubleFormatTest! Test4", calc.calculate("* 2"), "0.03");
    }

    private static void wrongCommandTest() {
        Calculator calc = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in wrongCommandTest! Test1", calc.calculate("+ 2"), WRONG_MSG);
        Assert.assertStringsAreEqual("Error in wrongCommandTest! Test2", calc.calculate("0.21 -1_1"), WRONG_MSG);
        Assert.assertStringsAreEqual("Error in wrongCommandTest! Test3", calc.calculate("+ 2"), WRONG_MSG);
        Assert.assertStringsAreEqual("Error in wrongCommandTest! Test4", calc.calculate("+00.01 - + +2"), WRONG_MSG);
    }
}
