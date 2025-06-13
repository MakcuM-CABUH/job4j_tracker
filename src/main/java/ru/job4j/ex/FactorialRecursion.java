package ru.job4j.ex;

public class FactorialRecursion {
    public static int calc(int n) {
        int calc = (n - 1) * n;
        if (n == 0 || n == 1) {
            return 1;
        }
        return calc;
    }

    public static void main(String[] args) {
        int result = calc(0);
        System.out.println(result);
    }
}
