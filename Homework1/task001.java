/* Вычислить n-ое треугольное число (сумма чисел от 1 до n) */

package Homework1;

import java.util.Scanner;

public class task001 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Введите n-ое треугольное число: ");
            int value = input.nextInt();
            System.out.printf("Треугольное число %d равно %d", value, TringNumber(value));
        }
    }

    static int TringNumber(int num) {
        int result = num * (num + 1) / 2;
        return result;
    }
}
