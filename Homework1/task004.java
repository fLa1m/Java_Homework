/*Реализовать простой калькулятор 
(введите первое число, введите второе число, 
введите требуемую операцию, ответ) */

package Homework1;

import java.util.Scanner;

public class task004 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Введите 1ое число: ");
            double a = input.nextInt();
            System.out.print("Математическая операция(+, -, *, /): ");
            String op = input.next();
            System.out.print("Введите 2ое число: ");
            double b = input.nextInt();

            System.out.println(Calc(a, b, op));
        }
    }

    static double Calc(double a, double b, String op) {
        double result = 0;
        switch (op) {
            case ("+"):
                result = a + b;
                break;
            case ("-"):
                result = a - b;
                break;
            case ("*"):
                result = a * b;
                break;
            case ("/"):
                result = a / b;
                break;
        }
        return result;
    }
}
