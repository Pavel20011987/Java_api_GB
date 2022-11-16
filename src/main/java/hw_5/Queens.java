package hw_5;

/*
 *  На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

public class Queens {
    private static final int BOARD_SIZE = 8;
    private static int[] q = new int[BOARD_SIZE];

    public static boolean isValidCell(int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n] ||
                    (q[i] - q[n]) == (n - i) ||
                    (q[n] - q[i]) == (n - i)) {
                return false;
            }
        }
        return true;
    }

    public static void printQueens() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (q[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void placeQueen(int k) {
        if (k == BOARD_SIZE) {
            printQueens();
        } else {
            for (int i = 0; i < BOARD_SIZE; i++) {
                q[k] = i;
                if (isValidCell(k)) {
                    placeQueen(k + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        placeQueen(0);
    }
}
