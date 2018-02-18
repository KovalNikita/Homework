package ru.sberbank.homework.common;

import java.util.Scanner;

import ru.sberbank.homework.common.KovalsCalculator;
import ru.sberbank.homework.common.Assert;

public class CalculatorTest {
    public static void main(String[] args) {

        testBinLiterals();
        testOctLiterals();
        testDecLiterals();
        testHexLiterals();
        testDoubleFormat();
        System.out.println("All tests were passed successfully!");

        Scanner in = new Scanner(System.in);
        KovalsCalculator c = new KovalsCalculator();
        while (true) {
            String input = in.nextLine();
            if (input.equals("quit")) {
                break;
            }
            System.out.println(c.calculate(input));
        }
        System.out.println();
    }

    private static void testBinLiterals() {
        KovalsCalculator c = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in testBinLiterals! Test1", "6", c.calculate("0b1 + 0B101"));
        Assert.assertStringsAreEqual("Error in testBinLiterals! Test2", "30", c.calculate("* 0B101"));
        Assert.assertStringsAreEqual("Error in testBinLiterals! Test3", "10", c.calculate("/ 0b1____1"));
        Assert.assertStringsAreEqual("Error in testBinLiterals! Test4", "error > 0B10_1_", c.calculate("+ 0B10_1_"));
    }

    private static void testOctLiterals() {
        KovalsCalculator c = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in testOctLiterals! Test1", "133", c.calculate("011 + 0174"));
        Assert.assertStringsAreEqual("Error in testOctLiterals! Test2", "34447", c.calculate("* 040__3"));
        Assert.assertStringsAreEqual("Error in testOctLiterals! Test3", "error > 010_1_", c.calculate("- 010_1_"));
        Assert.assertStringsAreEqual("Error in testOctLiterals! Test4", "34448", c.calculate("+ 00_1"));
    }

    private static void testDecLiterals() {
        KovalsCalculator c = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in testDecLiterals! Test1", "275", c.calculate("101 + 174"));
        Assert.assertStringsAreEqual("Error in testDecLiterals! Test2", "error > 2_", c.calculate("* 2_"));
        Assert.assertStringsAreEqual("Error in testDecLiterals! Test3", "error > _1", c.calculate("- _1"));
        Assert.assertStringsAreEqual("Error in testDecLiterals! Test4", "error > 1i", c.calculate("+ 1i"));
    }

    private static void testHexLiterals() {
        KovalsCalculator c = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in testHexLiterals! Test1", "2560", c.calculate("0xABC - 0Xbc"));
        Assert.assertStringsAreEqual("Error in testHexLiterals! Test2", "256", c.calculate("0XF_F + 1"));
        Assert.assertStringsAreEqual("Error in testHexLiterals! Test2", "error > 0x2_", c.calculate("* 0x2_"));
        Assert.assertStringsAreEqual("Error in testHexLiterals! Test3", "error > 0x_1", c.calculate("- 0x_1"));
    }

    private static void testDoubleFormat() {
        KovalsCalculator c = new KovalsCalculator();
        Assert.assertStringsAreEqual("Error in testDoubleFormat! Test1", "6.67", c.calculate("20 / 3"));
        Assert.assertStringsAreEqual("Error in testDoubleFormat! Test2", "1.6", c.calculate("16 / 10"));
        Assert.assertStringsAreEqual("Error in testDoubleFormat! Test3", "0.02", c.calculate("/ 100"));
        Assert.assertStringsAreEqual("Error in testDoubleFormat! Test4", "0.03", c.calculate("* 2"));
    }
}
