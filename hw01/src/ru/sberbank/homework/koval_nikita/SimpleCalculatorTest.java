package ru.sberbank.homework.koval_nikita;

public class SimpleCalculatorTest {
    public static void main(String[] args) {

        addIntTest();
        subtractIntTest();
        multiplyIntTest();
        divideIntTest();

        addDoubleTest();
        subtractDoubleTest();
        multiplyDoubleTest();
        divideDoubleTest();
        divideByZeroDoubleTest();

        System.out.println("All tests were passed successfully!");
    }

    private static void addIntTest() {
        int actual = SimpleCalculator.add(2, 3);
        int expected = 5;
        Assert.assertIntsAreEqual("Error in addIntTest", expected, actual);
    }

    private static void subtractIntTest() {
        int actual = SimpleCalculator.subtract(21, 8);
        int expected = 13;
        Assert.assertIntsAreEqual("Error in subtractIntTest", expected, actual);
    }

    private static void multiplyIntTest() {
        int actual = SimpleCalculator.multiply(19, 2);
        int expected = 38;
        Assert.assertIntsAreEqual("Error in multiplyIntTest", expected, actual);
    }

    private static void divideIntTest() {
        int actual = SimpleCalculator.divide(14, 6);
        int expected = 2;
        Assert.assertIntsAreEqual("Error in divideIntTest", expected, actual);
    }

    private static void addDoubleTest() {
        double actual = SimpleCalculator.add(8.4, 3.6);
        double expected = 12;
        Assert.assertDoublesAreEqual("Error in addDoubleTest", expected, actual);
    }

    private static void subtractDoubleTest() {
        double actual = SimpleCalculator.subtract(8.31, 0.2);
        double expected = 8.11;
        Assert.assertDoublesAreEqual("Error in subtractDoubleTest", expected, actual);
    }

    private static void multiplyDoubleTest() {
        double actual = SimpleCalculator.multiply(2.47, 3.4);
        double expected = 8.398;
        Assert.assertDoublesAreEqual("Error in multiplyDoubleTest", expected, actual);
    }

    private static void divideDoubleTest() {
        double actual = SimpleCalculator.divide(9.86, 4.8);
        double expected = 2.0541667;
        Assert.assertDoublesAreEqual("Error in divideDoubleTest", expected, actual);
    }

    private static void divideByZeroDoubleTest() {
        double actual = SimpleCalculator.divide(9.86, 0.0);
        double expected = Double.POSITIVE_INFINITY;
        Assert.assertDoublesAreEqual("Error in divideByZeroDoubleTest", expected, actual);
    }
}
