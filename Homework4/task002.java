/*Реализуйте очередь с помощью LinkedList со следующими методами: 
enqueue() - помещает элемент в конец очереди, 
dequeue() - возвращает первый элемент из очереди и удаляет его, 
first() - возвращает первый элемент из очереди, не удаляя. */

package Homework4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class task002 {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        list.add(22);
        list.add(17);
        list.add(6);
        Scanner iScanner = new Scanner(System.in);
        boolean work = true;

        while (work) {
            System.out.println();
            System.out.println("Введите команду: ");
            String values = iScanner.nextLine();

            switch (values) {
                case "enqueue":
                    enqueue(list);
                    break;
                case "exit":
                    work = false;
                    break;
                case "dequeue":
                    dequeue(list);
                    break;
                case "first":
                    first(list);
                    break;
                case "show":
                    System.out.println(list);
                    break;
            }
        }

        iScanner.close();
    }

    static void enqueue(Queue<Integer> list) {
        System.out.println();
        System.out.println("Введите элемент: ");
        Scanner input = new Scanner(System.in);
        list.add(input.nextInt());

    }

    static void dequeue(Queue<Integer> list) {
        System.out.println(list.poll());
    }

    static void first(Queue<Integer> list) {
        System.out.println(list.peek());
    }
}
