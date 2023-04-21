/*Задано уравнение вида q + w = e, q, w, e >= 0. 
Некоторые цифры могут быть заменены знаком вопроса, 
например, 2? + ?5 = 69. Требуется восстановить выражение 
до верного равенства. Предложить хотя бы одно решение 
или сообщить, что его нет. */

package Homework1;

public class task005 {
    public static void main(String[] args) {

        String valString = "2? + ?5 = 69";

        String separator = MathMethod(valString);

        String operation = FindOperation(valString);

        String[] tempArray = CreateArray(valString, separator);

        String result = SelectionDigits(tempArray, operation);

        if (result == "") {
            System.out.println("Решений нет.");
        } else {
            System.out.println(result);
        }
    }

    static String MathMethod(String text) {

        String op = "";

        if (text.contains("+")) {
            op = "\\+|\\=";
        } else if (text.contains("-")) {
            op = "\\-|\\=";
        } else if (text.contains("*")) {
            op = "\\*|\\=";
        } else if (text.contains("/")) {
            op = "\\/|\\=";
        }

        return op;
    }

    static String[] CreateArray(String text, String operation) {

        String[] valArr = text.split(operation);

        for (int i = 0; i < valArr.length; i++) {
            valArr[i] = valArr[i].replace(" ", "");
        }

        return valArr;
    }

    static boolean CheckEquation(int[] numArray, String op) {

        boolean flag = false;

        if (op == "+") {
            if (numArray[0] + numArray[1] == numArray[2]) {
                flag = true;
            }
        }

        if (op == "-") {
            if (numArray[0] - numArray[1] == numArray[2]) {
                flag = true;
            }
        }

        if (op == "*") {
            if (numArray[0] * numArray[1] == numArray[2]) {
                flag = true;
            }
        }

        if (op == "/") {
            if (numArray[0] / numArray[1] == numArray[2]) {
                flag = true;
            }
        }

        return flag;
    }

    static String SelectionDigits(String[] array, String op) {

        int[] numArray = new int[3];

        String res = "";

        for (int i = 0; i < 10; i++) {

            String iString = Integer.toString(i);

            if (array[0].contains("?")) {
                numArray[0] = Integer.parseInt(array[0].replace("?", iString));
            } else {
                numArray[0] = Integer.parseInt(array[0]);
            }

            for (int j = 0; j < 10; j++) {

                String jString = Integer.toString(j);

                if (array[1].contains("?")) {
                    numArray[1] = Integer.parseInt(array[1].replace("?", jString));
                } else {
                    numArray[1] = Integer.parseInt(array[1]);
                }

                for (int k = 0; k < 10; k++) {

                    String kString = Integer.toString(k);

                    if (array[2].contains("?")) {
                        numArray[2] = Integer.parseInt(array[2].replace("?", kString));
                    } else {
                        numArray[2] = Integer.parseInt(array[2]);
                    }

                    if (CheckEquation(numArray, op)) {
                        res = String.format("%d %s %d = %d", numArray[0], op, numArray[1], numArray[2]);
                    }
                }
            }
        }
        return res;
    }

    static String FindOperation(String text) {

        String opString = "";

        if (text.contains("+")) {
            opString = "+";
        } else if (text.contains("-")) {
            opString = "-";
        } else if (text.contains("*")) {
            opString = "*";
        } else if (text.contains("/")) {
            opString = "/";
        }

        return opString;
    }
}
