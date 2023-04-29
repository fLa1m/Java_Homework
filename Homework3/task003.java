/*Заполнить список названиями планет Солнечной системы 
в произвольном порядке с повторениями. Вывести название 
каждой планеты и количество его повторений в списке. */

package Homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class task003 {
    public static void main(String[] args) {
        String[] planetString = { "Меркурий", "Венера", "Земля", "Марс",
                "Юпитер", "Сатурн", "Уран", "Нептун" };

        List<String> planetList = createList(10, planetString);

        System.out.println(planetList);

        amountWords(planetList, planetString);
    }

    static List<String> createList(int size, String[] arrayString) {

        List<String> list = new ArrayList<>();

        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            list.add(arrayString[rnd.nextInt(arrayString.length)]);
        }

        return list;
    }

    static void amountWords(List<String> list, String[] arrayString) {

        for (int i = 0; i < arrayString.length; i++) {

            if (Collections.frequency(list, arrayString[i]) != 0) {

                System.out.printf("%s = %d\n", arrayString[i],
                        Collections.frequency(list, arrayString[i]));

            }
        }
    }
}
