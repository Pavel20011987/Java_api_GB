package hw_2.src.main.java.com.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 2. Реализуйте алгоритм сортировки пузырьком числового массива, результат
 * после каждой итерации запишите в лог-файл.
 */
public class LoggingSort {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggingSort.class.getName());
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.FINE);

        try {
            FileHandler fh = new FileHandler("sort.log");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Cannot create file handler", e);
        }

        int[] data = new int[20];
        Random rnd = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = rnd.nextInt(100);
        }
        String msg = "Created array: " + Arrays.toString(data);
        System.out.println(msg);
        logger.log(Level.INFO, msg);

        for (int i = data.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (data[j - 1] > data[j]) {
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
            logger.fine(Arrays.toString(data));
        }

        msg = "Sorted array: " + Arrays.toString(data);
        System.out.println(msg);
        logger.info(msg);
    }
}
