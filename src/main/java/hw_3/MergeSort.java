package hw_3;

import java.util.*;

public class MergeSort {
    /**
     * 1. Реализовать алгоритм сортировки слиянием
     */
    public static void sort(List<Integer> a) {
        if (a.size() <= 1) {
            return;
        }

        int mid = a.size() / 2;

        List<Integer> first = new ArrayList<>(a.subList(0, mid));
        List<Integer> second = new ArrayList<>(a.subList(mid, a.size()));

        sort(first);
        sort(second);
        merge(first, second, a);
    }

    public static void merge(List<Integer> first, List<Integer> second, List<Integer> target) {
        int iterFirst = 0;
        int iterSecond = 0;
        int j = 0;

        while (iterFirst < first.size() && iterSecond < second.size()) {
            if (first.get(iterFirst) < second.get(iterSecond)) {
                target.set(j, first.get(iterFirst));
                iterFirst++;
            } else {
                target.set(j, second.get(iterSecond));
                iterSecond++;
            }
            j++;
        }

        while (iterFirst < first.size()) {
            target.set(j, first.get(iterFirst));
            j++;
            iterFirst++;
        }

        while (iterSecond < second.size()) {
            target.set(j, second.get(iterSecond));
            j++;
            iterSecond++;
        }
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();

        Random rnd = new Random();
        for (int i = 0; i < 16; i++) {
            lst.add(rnd.nextInt(150));
        }

        System.out.println(lst);

        sort(lst);

        System.out.println(lst);
    }
}
