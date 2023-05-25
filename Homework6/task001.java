/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий 
(или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
Критерии фильтрации можно хранить в Map. 
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - 
сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

Работу сдать как обычно ссылкой на гит репозиторий

P.S. Частые ошибки смотри в конце семинара */

package Homework6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class task001 {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("AMD Ryzen 5", 16, 512,
                "Linux", "black");
        Notebook notebook2 = new Notebook("Intel Core i5", 16, 512,
                "Windows 11 Home", "silver");
        Notebook notebook3 = new Notebook("Intel Core i5", 8, 512,
                "Windows 11 Home", "gray");
        Notebook notebook4 = new Notebook("Intel Core i3", 8, 256,
                "Windows 10 Home", "gray");
        Notebook notebook5 = new Notebook("AMD Ryzen 7", 16, 512,
                "Windows 11 Home", "white");
        Notebook notebook6 = new Notebook("Apple M1 Pro", 16, 512,
                "macOS", "white");

        HashSet<Notebook> shop = new HashSet<>(Arrays.asList(notebook1, notebook2,
                notebook3, notebook4, notebook5, notebook6));

        TreeMap<Integer, String> parametrs = new TreeMap<>();
        parametrs.put(1, "CPU");
        parametrs.put(2, "RAM");
        parametrs.put(3, "HDD");
        parametrs.put(4, "OS");
        parametrs.put(5, "Color");
        parametrs.put(6, "Search");

        HashMap<String, Object> searchParam = new HashMap<>();
        Scanner iScanner = new Scanner(System.in, "cp866");

        System.out.println("Введите цифру, соответствующую необходимому критерию, для начала поиска введите 6:");
        for (Map.Entry<Integer, String> element : parametrs.entrySet()) {
            System.out.println(element.getKey() + " - " + element.getValue());
        }
        Integer values = iScanner.nextInt();
        iScanner.nextLine();
        while (values != 6) {
            if (values == 1) {
                System.out.println("Введите название процессора:");
                String temp = iScanner.nextLine();
                searchParam.put("CPU", temp);
            }
            if (values == 2) {
                System.out.println("Введите минимальный объем RAM:");
                Integer temp = iScanner.nextInt();
                searchParam.put("RAM", temp);
            }
            if (values == 3) {
                System.out.println("Введите минимальный объем HDD:");
                Integer temp = iScanner.nextInt();
                searchParam.put("HDD", temp);
            }
            if (values == 4) {
                System.out.println("Введите желаемую OS:");
                String temp = iScanner.nextLine();
                searchParam.put("OS", temp);
            }
            if (values == 5) {
                System.out.println("Введите желаемый цвет:");
                String temp = iScanner.nextLine();
                searchParam.put("Color", temp);
            }
            System.out.println("Введите цифру, соответствующую необходимому критерию, для начала поиска введите 6:");
            for (Map.Entry<Integer, String> element : parametrs.entrySet()) {
                System.out.println(element.getKey() + " - " + element.getValue());
            }
            values = iScanner.nextInt();
            iScanner.nextLine();
        }

        HashSet<Notebook> result = new HashSet<>();
        boolean allFiltersMatch = true;
        Iterator<Notebook> iterator = shop.iterator();
        while (iterator.hasNext()) {
            Notebook note = (Notebook) iterator.next();
            for (Map.Entry<String, Object> el : searchParam.entrySet()) {
                switch (el.getKey()) {
                    case "CPU":
                        if (!note.getCpu().contains((String) el.getValue())) {
                            allFiltersMatch = false;
                        }
                        break;
                    case "RAM":
                        if (note.getRam() < (Integer) el.getValue()) {
                            allFiltersMatch = false;
                        }
                        break;
                    case "HDD":
                        if (note.getHdd() < (Integer) el.getValue()) {
                            allFiltersMatch = false;
                        }
                        break;
                    case "OS":
                        if (!note.getOs().contains((String) el.getValue())) {
                            allFiltersMatch = false;
                        }
                        break;
                    case "Color":
                        if (!note.getColor().contains((String) el.getValue())) {
                            allFiltersMatch = false;
                        }
                        break;
                }
            }
            if (allFiltersMatch == true) {
                result.add(note);
            }
            allFiltersMatch = true;
        }
        for (Notebook nt : result) {
            System.out.println(nt);
        }
        iScanner.close();
    }
}
