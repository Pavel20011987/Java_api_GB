package com.example;

import java.util.Scanner;

/**
 * Задание 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
 * (произведение чисел от 1 до n)
 *
 */
public class TriangleNumber {
    public static int calcTriNumIter(int n) {
        int triNum = 0;
        for (int i = 1; i <= n; i++) {
            triNum += i;
        }
        return triNum;
    }

    public static int calcFactorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= n;
        }
        return fact;
    }

    public static int calcFactorialRec(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calcFactorialRec(n - 1);
    }

    public static int calcTriNumRec(int n) {
        if (n == 0) {
            return 0;
        }
        return n + calcTriNumRec(n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите порядковый номер треугольного числа: ");
        int number = scn.nextInt();
        System.out.printf("Треугольное число %d = %d\n", number, calcTriNumIter(number));
        System.out.printf("Повторяю, треугольное число %d = %d\n", number, calcTriNumRec(number));
        scn.close();
    }

}