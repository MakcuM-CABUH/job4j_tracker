package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }

    public static int max(int left, int right, int three) {
        return max(max(left, right), three);
    }

    public static int max(int left, int right, int three, int four) {
        return max(max(left, right), max(three, four));
    }

    public static void main(String[] args) {
        String maxFromLeftToRight = String.valueOf(Max.max(2, 8));
        System.out.println(maxFromLeftToRight);

        String maxFromThree = String.valueOf(Max.max(2, 8, 12));
        System.out.println(maxFromThree);

        String maxFromFour = String.valueOf(Max.max(2, 8, 12, 61));
        System.out.println(maxFromFour);
    }
}
