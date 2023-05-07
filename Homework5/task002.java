/*Пусть дан список сотрудников: 

Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, 
Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, 
Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, 
Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. 

Написать программу, которая найдет и выведет повторяющиеся имена 
с количеством повторений. Отсортировать по убыванию популярности. 
Для сортировки использовать TreeMap. */

package Homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class task002 {
    public static void main(String[] args) {
        String s = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, " +
                "Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, " +
                "Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, " +
                "Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";

        List<String> sName = splitString(s);
        Set<String> uniqName = new TreeSet<>();
        uniqName.addAll(sName);
        System.out.println(countName(sName, uniqName));
        ;
    }

    static List<String> splitString(String s) {
        s = s.replace(".", "");
        s = s.replace(",", "");
        String[] listString = s.split(" ");
        for (int i = 1; i < listString.length; i = i + 2) {
            listString[i] = "0";
        }
        List<String> list = new ArrayList<>(Arrays.asList(listString));
        while (list.remove("0")) {
        }
        return list;
    }

    static String countName(List<String> names, Set<String> uniqName) {
        Map<Integer, List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        for (String elString : uniqName) {
            int count = Collections.frequency(names, elString);
            if (map.containsKey(count)) {
                List<String> list = map.get(count);
                list.add(elString);
            } else {
                List<String> list = new ArrayList<>();
                list.add(elString);
                map.put(count, list);
            }
        }

        StringBuilder sBuilder = new StringBuilder();
        for (Map.Entry<Integer, List<String>> el : map.entrySet()) {
            sBuilder.append(el.getValue());
            sBuilder.append(": ");
            sBuilder.append(el.getKey());
            sBuilder.append("\n");
        }

        return sBuilder.toString();
    }
}
