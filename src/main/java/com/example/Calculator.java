package com.example;

import java.util.*;
import java.util.regex.*;

/**
 * Задание 3. Реализовать простой калькулятор
 * Работает с выражениями типа операнд оператор операнд
 * операнды - действительные числа
 * оператор - +, -, *, /
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = scn.nextLine();

        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("([0-9.]+)|(\\-|\\+|\\*|\\/)");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            tokens.add(matcher.group().strip());
        }

        double result = 0.0;
        double x = Double.parseDouble(tokens.get(0));
        double y = Double.parseDouble(tokens.get(2));
        switch (tokens.get(1)) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            default:
                result = Double.NaN;
        }

        if (Double.isNaN(result)) {
            System.out.println("Вы ввели неверное выражение");
        } else {
            System.out.println(expression + " = " + result);
        }

        scn.close();
    }

}
