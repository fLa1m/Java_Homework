/* Вычислить n! (произведение чисел от 1 до n) */
package Homework1;

import java.util.Scanner;

public class task002 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Введите число: ");
            int number = input.nextInt();
            System.out.printf("%d! = %d", number, Factorial(number));
        }
    }

    static int Factorial(int num) {
        int result = 1;
        for (int i = 2; i < num + 1; i++) {
            result *= i;
        }
        return result;
    }
}
