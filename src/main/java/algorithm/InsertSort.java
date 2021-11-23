package algorithm;

public class InsertSort {
    public static void main(String[] args) {
        int[] ints = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for (int i = 1; i < 10; i++) {
            int num = ints[i];

            int j = i - 1;
            while (j >= 0 && num < ints[j]) {
                ints[j + 1] = ints[j];
                j--;
            }

            ints[j + 1] = num;
        }

        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
