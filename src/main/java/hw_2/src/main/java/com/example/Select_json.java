package hw_2.src.main.java.com.example;

import org.json.JSONObject;
import org.json.JSONTokener;
import java.util.Iterator;
/*
 * 1. Дана строка sql-запроса "select * from students where ". 
 * Сформируйте часть WHERE этого запроса, используя StringBuilder. 
 * Данные для фильтрации приведены ниже в виде json строки. Разберите строку, используя String.split.

Если значение null, то параметр не должен попадать в запрос.

Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

public class Select_json {

    static String createRequestString(String[] paramName, String[] paramValue) {

        // Возвращаем пустую строку для массивов нулевой длины
        if (paramName.length == 0 || paramValue.length == 0) {
            return "";
        }

        StringBuilder requestString = new StringBuilder();
        // Если длина массивов одинаковая собираем строку
        if (paramName.length == paramValue.length) {
            // Проверка для массива длины 1
            if (paramName.length == 1) {
                requestString.append(String.format(" WHERE %s=\'%s\'", paramName[0], paramValue[0]));
                return requestString.toString();
            }

            requestString.append(" WHERE ");
            // Делаем конкатенацию строк через цикл
            for (int i = 0; i < paramValue.length; i++) {
                requestString.append(String.format("%s=\'%s\'", paramName[i], paramValue[i]));
                if (i != paramName.length - 1) {
                    requestString.append(" AND ");
                }
            }
            return requestString.toString();
        }
        return "";
    }

    // метод для перевода json в строку SQL
    static String jsonToSql(String jsonString) {
        StringBuilder requestString = new StringBuilder(" WHERE ");
        // Создаём json объект.
        JSONObject jo = new JSONObject(jsonString);
        Iterator<String> key = jo.keys();
        while (key.hasNext()) {
            String str = key.next();
            if (key.hasNext() != true) {
                requestString.append(String.format("%s=\"%s\"", str, jo.get(str)));
            } else {
                requestString.append(String.format("%s=\"%s\" AND ", str, jo.get(str)));
            }
        }
        return requestString.toString();

    }

    public static void main(String[] args) {
        String sqlRequest = "select * from students";
        String[] paramName = { "name", "country", "city" };
        String[] paramValue = { "Ivanov", "Russia", "Moscow" };
        String response = createRequestString(paramName, paramValue);
        System.out.println(sqlRequest + response);
        // String jsonString = "{\"name\": \"kakashi\", \"damage\":\"100\"}";
        // String result2 = sqlRequest + jsonToSql(jsonString);
        // System.out.println(result2);

    }
}
