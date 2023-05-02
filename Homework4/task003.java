/*Найдите сумму всех элементов LinkedList, 
сохраняя все элементы в списке. Используйте итератор */

package Homework4;

import java.util.Iterator;
import java.util.LinkedList;

public class task003 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println("Сумма элементов: " + sumList(list));

    }

    static int sumList(LinkedList<Integer> list) {
        int sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }
}
