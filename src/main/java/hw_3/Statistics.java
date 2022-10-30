package hw_3;

/*
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */
import java.util.*;

public class Statistics {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();

        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            lst.add(rnd.nextInt(100));
        }

        int min = lst.get(0);
        int max = lst.get(0);
        int sum = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            int tmp = lst.get(i);

            if (tmp > max) {
                max = tmp;
            }
            if (tmp < min) {
                min = tmp;
            }
            sum += tmp;
        }

        System.out.println("Array: " + lst);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Average: " + 1.0 * sum / lst.size());
    }
}
