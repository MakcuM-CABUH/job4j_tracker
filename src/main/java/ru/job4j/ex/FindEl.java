package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;

        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }

        if (result == -1) {
            throw new ElementNotFoundException("Element not found in the array");
        }

        return result;
    }

    public static void main(String[] args) {
        String[] array = {"one", "two", "three"};
        try {
            int result = indexOf(array, "key");
            System.out.println(result);
        } catch (ElementNotFoundException e) {
            System.out.println("Element Not Found Exception");
        }
    }
}
