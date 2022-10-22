package com.example;

import java.util.*;

/**
 * Задание 4. +Задано уравнение вида q + w = e, q, w, e >= 0.
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
 * Требуется восстановить выражение до верного равенства. Предложить хотя бы
 * одно решение или сообщить, что его нет.
 */
public class RestoreEquation {
    public static int countQuestionMarks(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                count++;
            }
        }
        return count;
    }

    public static int getNumber(String s) {
        String t = s.replaceAll("\\?", "0");
        return Integer.parseInt(t);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите урвнение: ");
        String[] equation = scn.nextLine().split("\\s+");
        scn.close();

        // проверяем есть ли знаки вопроса и сколько их
        if (countQuestionMarks(equation[0]) > 1 || countQuestionMarks(equation[2]) > 1) {
            System.out.println("Уравнение не имеет решений или имеет бесконечное множество решений");
        } else {
            int x = getNumber(equation[0]);
            int y = getNumber(equation[2]);
            int z = getNumber(equation[4]);

            int xFactor = x < 10 ? 10 : 1;
            int yFactor = y < 10 ? 10 : 1;
            int solutionCount = 0;

            // находим решение полным перебором вариантов
            // находятся также варианты, когда одно из слагаемых
            // однозначное число, в принципе, если оба должны быть двузначными
            // это легко исправить изменив старт переборв на 1 если в числе нам известна
            // только 2-я цифра, таким образом: int start = x < 10 ? 1 : 0
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int xCandidate = x + i * xFactor;
                    int yCandidate = y + j * yFactor;
                    if (xCandidate + yCandidate == z) {
                        solutionCount++;
                        System.out.println("Найдено решение " + solutionCount +
                                " : " + xCandidate + " + " + yCandidate +
                                " = " + z);
                    }
                }
            }

            if (solutionCount == 0) {
                System.out.println("Решений нет");
            }
        }
    }
}
