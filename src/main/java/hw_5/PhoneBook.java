package hw_5;

import java.util.*;
import java.util.Map.Entry;

/**
 * Задание 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
 * что 1 человек может иметь несколько телефонов.
 * Задание 2. Написать программу, которая найдет и выведет повторяющиеся имена с
 * количеством повторений. Отсортировать по убыванию популярности.
 */
public class PhoneBook {
    private static Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void addRecord(String name, String phoneNumber) {
        if (phoneBook.get(name) == null) {
            phoneBook.put(name, new ArrayList<String>());
        }
        phoneBook.get(name).add(phoneNumber);
    }

    public static ArrayList<String> findRecord(String name) {
        return phoneBook.get(name);
    }

    public static void main(String[] args) {
        addRecord("Иванов Иван", "111-11-11");
        addRecord("Петров Петр", "222-22-22");
        addRecord("Сидорова Светлана", "333-33-33");
        addRecord("Иванов Иван", "444-44-44");
        addRecord("Петров Петр", "222-22-23");
        addRecord("Петров Петр", "222-22-24");
        addRecord("Кузнецов Константин", "777-77-77");

        ArrayList<Map.Entry<String, ArrayList<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort(new Comparator<Map.Entry<String, ArrayList<String>>>() {
            public int compare(Map.Entry<String, ArrayList<String>> e1, Map.Entry<String, ArrayList<String>> e2) {
                if (e1.getValue().size() < e2.getValue().size()) {
                    return 1;
                } else if (e1.getValue().size() == e2.getValue().size()) {
                    return 0;
                }
                return -1;
            }
        });

        for (Entry<String, ArrayList<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " номер(а)");
        }

    }
}
