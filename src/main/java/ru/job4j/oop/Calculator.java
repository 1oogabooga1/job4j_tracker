package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int a) {
        return x - a;
    }

    public int divide(int b) {
        return b / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int c) {
        return sum(c) + minus(c) + divide(c) + multiply(c);
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println(minus(10));
        Calculator calc = new Calculator();
        System.out.println(calc.divide(10));
        System.out.println(calc.multiply(10));
        System.out.println(calc.sumAllOperation(10));
    }

}
