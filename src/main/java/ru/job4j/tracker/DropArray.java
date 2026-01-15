package ru.job4j.tracker;

import java.util.Arrays;

/**  модель:  System.arraycopy(source, startPos, dist, distPos, length);
 * source - массив ОТКУДА копируем элементы.            (у нас "names")
 * startPos - стартовая позиция копирования             (у нас "2")
 * dist - массив, КУДА вставить скопированные элементы (можно в тот же массив - в данном случае sourse)
 *                                                      (у нас "names" - тот же массив, но можно и другой)
 * distPos - начиная с какого элемента вставлять скопированные ячейки.
 *                                                      (у нас "1")
 * length - сколько элементов КОПИРУЕМ начиная от startPos
 *                                                      (у нас "3")
 */
public class DropArray {
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", null};
        System.arraycopy(names, 2, names, 1, 3);
//
//        String[] result = new String[names.length];
//        int size = 0;
//        for (int index = 0; index < names.length; index++) {
//            String name = names[index];
//            if (name != null) {
//                result[size] = name;
//                size++;
//            }
//        }
//        result = Arrays.copyOf(result, size);
//        for (int index = 0; index < result.length; index++) {
//            System.out.println(result[index]);
//      !!!  предыдущую строку переписываем в .... см. ниже
        System.out.println(Arrays.toString(names));
    }
}
