package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return y + x;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int multiply(int a) {
        return a * x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int c) {
        return sum(c) + minus(c) + multiply(c) + divide(c);
    }

    public static void main(String[] args) {
        int resultSum = Calculator.sum(10);
        System.out.println(resultSum);

        int resultMinus = Calculator.minus(11);
        System.out.println(resultMinus);

        Calculator calculatorMultiply = new Calculator();
        int resultMultiply = calculatorMultiply.multiply(5);
        System.out.println(resultMultiply);

        Calculator calculatorDivide = new Calculator();
        int resultDivide = calculatorDivide.divide(15);
        System.out.println(resultDivide);

        Calculator calculatorSumAll = new Calculator();
        int resultSumAll = calculatorSumAll.sumAllOperation(5);
        System.out.println(resultSumAll);
    }
}