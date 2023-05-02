/*Пусть дан LinkedList с несколькими элементами. 
Реализуйте метод, который вернет “перевернутый” список. 
Постараться не обращаться к листу по индексам. */

package Homework4;

import java.util.LinkedList;
import java.util.ListIterator;

public class task001 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(10);
        list.add(6);
        list.add(7);
        System.out.println(list);
        reverseList(list);
    }

    static void reverseList(LinkedList<Integer> list) {
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.printf("%d ", listIterator.previous());
        }
    }
}
