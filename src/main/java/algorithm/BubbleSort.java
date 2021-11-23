package algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }

        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
