package hw_3;

/*
 * Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RemoveEven {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();

        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            lst.add(rnd.nextInt(100));
        }

        System.out.println(lst);

        Iterator<Integer> it = lst.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove();
            }
        }

        System.out.println(Arrays.toString(lst.toArray()));
    }
}
