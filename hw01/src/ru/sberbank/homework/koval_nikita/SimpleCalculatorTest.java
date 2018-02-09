package ru.sberbank.homework.koval_nikita;

public class SimpleCalculatorTest{
	public static void main(String[] args) throws Exception{
		
		testIntAdd();
		testIntSub();
		testIntMult();
		testIntDiv();
		
		testDoubleAdd();
		testDoubleSub();
		testDoubleMult();
		testDoubleDiv();
		
		System.out.println("All tests were passed successfully!");
	}
	
	public static void testIntAdd()throws Exception{
		int actual = SimpleCalculator.add(2,3);
		int expected = 5;
		Assert.assertIntsIsEqual("Error!", expected, actual);
	}
	
	public static void testIntSub()throws Exception{
		int actual = SimpleCalculator.sub(21,8);
		int expected = 13;
		Assert.assertIntsIsEqual("Error!", expected, actual);
	}
	
	public static void testIntMult()throws Exception{
		int actual = SimpleCalculator.mult(19,2);
		int expected = 38;
		Assert.assertIntsIsEqual("Error!", expected, actual);
	}
	
	public static void testIntDiv()throws Exception{
		int actual = SimpleCalculator.div(14,6);
		int expected = 2;
		Assert.assertIntsIsEqual("Error!", expected, actual);
	}
	
	public static void testDoubleAdd()throws Exception{
		double actual = SimpleCalculator.add(8.4,3.6);
		double expected = 12;
		Assert.assertDoublesIsEqual("Error!", expected, actual);
	}
	
	public static void testDoubleSub()throws Exception{
		double actual = SimpleCalculator.sub(8.31,0.2);
		double expected = 8.11;
		Assert.assertDoublesIsEqual("Error!", expected, actual);
	}
	
	public static void testDoubleMult()throws Exception{
		double actual = SimpleCalculator.mult(2.47,3.4);
		double expected = 8.398;
		Assert.assertDoublesIsEqual("Error!", expected, actual);
	}
	
	public static void testDoubleDiv()throws Exception{
		double actual = SimpleCalculator.div(9.86,4.8);
		double expected = 2.0541667;
		Assert.assertDoublesIsEqual("Error!", expected, actual);
	}
}
