/*Задан целочисленный список ArrayList. 
Найти минимальное, максимальное и среднее 
арифметическое из этого списка. Collections.max() */

package Homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class task002 {
    public static void main(String[] args) {

        List<Integer> numList = createArray(10, 1, 9);

        System.out.println(numList);

        System.out.printf("min = %d\n", Collections.min(numList));

        System.out.printf("max = %d\n", Collections.max(numList));

        System.out.printf("avg = %.1f\n", getAverage(numList));
    }

    static List<Integer> createArray(int size, int min, int max) {

        List<Integer> list = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(min, max + 1));
        }

        return list;
    }

    static Double getAverage(List<Integer> list) {

        int sumNum = 0;

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            sumNum += iterator.next();
        }

        double avg = (double) sumNum / (double) list.size();

        return avg;
    }
}
