/*Дана json строка 
[{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Задача написать метод(ы), который распарсит строку и выдаст ответ вида:

Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

Используйте StringBuilder для подготовки ответа

Исходная json строка это просто String !!! Для работы используйте методы String, 
такие как replace, split, substring и т.д. по необходимости

Создать метод, который запишет результат работы в файл. 
Обработайте исключения и запишите ошибки в лог файл. */

package Homework2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class task001 {
    public static void main(String[] args) {

        String data = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        String[] dataArray = parseString(data);

        String result = buildString(dataArray);

        SaveToFile(result);
    }

    static String[] parseString(String text) {

        text = text.replaceAll("[\\[\\]\"\\{]", "");
        text = text.replaceAll(",", " ");

        String[] dataArr = text.split("}");

        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = dataArr[i].trim();
        }

        return dataArr;
    }

    static String buildString(String[] textArr) {

        StringBuilder result = new StringBuilder();

        String[] resultArr = { "Студент ", " получил ", " по предмету " };

        for (int i = 0; i < textArr.length; i++) {

            String[] tempArray = textArr[i].split(" ");

            for (int j = 0; j < tempArray.length; j++) {

                String[] tempArray2 = tempArray[j].split(":");
                result.append(resultArr[j]);
                result.append(tempArray2[1]);

            }

            result.append(".\n");
        }
        return result.toString();
    }

    static void SaveToFile(String text) {
        Logger logger = Logger.getAnonymousLogger();

        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");

        } catch (IOException e) {

            e.printStackTrace();
        }

        logger.addHandler(fileHandler);
        String path = "task001text.txt";

        try (FileWriter fileWriter = new FileWriter(path, false);) {
            fileWriter.write(text);

            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Что-то пошло не так");
        }
        fileHandler.close();
    }
}
