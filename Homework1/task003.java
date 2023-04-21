/* Вывести все простые числа от 1 до 1000 
(числа, которые делятся только на 1 и на себя без остатка) */

package Homework1;

import java.util.Scanner;

public class task003 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Введите начальное значение интервала: ");
            int start = input.nextInt();
            System.out.print("Введите конечное значение интервала: ");
            int end = input.nextInt();
            System.out.println(SimpleDigit(start, end));
        }
    }

    static String SimpleDigit(int start, int end) {
        String result = "";

        for (int i = start; i <= end; i++) {
            if (CheckSimple(i)) {
                result += "<" + i + ">" + " ";
            }
        }

        return result;
    }

    static boolean CheckSimple(int num) {

        if (num <= 1) {
            return false;
        }

        int div = 2;
        int count = 0;
        while (div < num) {
            if (num % div == 0) {
                count++;
            }
            div++;
        }
        if (count != 0) {
            return false;
        } else {
            return true;
        }
    }
}
