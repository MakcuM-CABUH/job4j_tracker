package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }

    public static int max(int left, int right, int three) {
        int temp = left > right ? left : right;
        int result = temp > three ? temp : three;
        return result;
    }

    public static int max(int left, int right, int three, int four) {
        int temp1 = left > right ? left : right;
        int temp2 = three > four ? three : four;
        int result = temp1 > temp2 ? temp1 : temp2;
        return result;
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