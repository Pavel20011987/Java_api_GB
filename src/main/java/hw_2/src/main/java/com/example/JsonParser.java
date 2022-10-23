package hw_2.src.main.java.com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Дана json строка (можно сохранить в файл и читать из файла) 
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}] 
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
 * Студент [фамилия] получил [оценка] по предмету [предмет]. 
 * Пример вывода: Студент Иванов получил 5 по предмету Математика. 
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */

import clojure.lang.Var;

public class JsonParser {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // получаем строку из файла
        Scanner scanner = new Scanner(new FileInputStream("data.json"));
        String s = scanner.nextLine();
        scanner.close();

        // парсим строку, собираем строку сперва в StringBuilder,
        // затем строки складываем в ArrayList
        ArrayList<String> messages = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int idx = i;
            char current = s.charAt(i);
            if (current == '\"') {
                idx = s.indexOf('\"', i + 1);
                String word = s.substring(i + 1, idx);
                if (word.equals("фамилия")) {
                    sb.append("Студент ");
                } else if (word.equals("оценка")) {
                    sb.append(" получил ");
                } else if (word.equals("предмет")) {
                    sb.append(" по предмету ");
                } else {
                    sb.append(word);
                }
            }
            if (current == '}') {
                messages.add(sb.toString());
                sb.setLength(0);
            }
            i = idx;
        }

        // Выводим строки на экран``1
        for (String msg : messages) {
            System.out.println(msg);
        }
    }

}
