/*Пусть дан произвольный список целых чисел, удалить из него четные числа */

package Homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class task001 {
    public static void main(String[] args) {
        List<Integer> numList = createArray(10, 1, 9);
        System.out.println(numList);
        removeEven(numList);
        System.out.println(numList);
    }

    static List<Integer> createArray(int size, int min, int max) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(min, max + 1));
        }
        return list;
    }

    static void removeEven(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }
}
