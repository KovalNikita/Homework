package ru.sberbank.homework.koval_nikita;

public class Assert {
	static double eps = 1e-5;
	public static void assertIntsIsEqual(String message, int  expected, int  actual) throws Exception{
		if(expected != actual){
			throw new Exception(message);
		}
	}
	public static void assertDoublesIsEqual(String message, double  expected, double  actual) throws Exception{
		if( Math.abs(expected - actual)  >= eps ){
			throw new Exception(message);
		}
	}
}
