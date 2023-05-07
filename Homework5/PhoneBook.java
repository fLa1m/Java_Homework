package Homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> map = new HashMap<>();

    void add(String contactName, String phoneNum) {
        if (map.containsKey(contactName)) {
            List<String> list = map.get(contactName);
            list.add(phoneNum);
        } else {
            List<String> list = new ArrayList<>();
            list.add(phoneNum);
            map.put(contactName, list);
        }
    }

    String getAllBook() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, List<String>> element : map.entrySet()) {
            stringBuilder.append(element.getKey());
            stringBuilder.append(": ");
            int size = element.getValue().size();
            for (int i = 0; i < size - 1; i++) {
                stringBuilder.append(element.getValue().get(i));
                stringBuilder.append(", ");
            }
            stringBuilder.append(element.getValue().get(size - 1));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    String findContact(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, List<String>> elMap : map.entrySet()) {
            if (elMap.getKey().contains(s)) {
                stringBuilder.append(elMap.getKey());
                stringBuilder.append(": ");
                int size = elMap.getValue().size();
                for (int i = 0; i < size - 1; i++) {
                    stringBuilder.append(elMap.getValue().get(i));
                    stringBuilder.append(", ");
                }
                stringBuilder.append(elMap.getValue().get(size - 1));
                stringBuilder.append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
