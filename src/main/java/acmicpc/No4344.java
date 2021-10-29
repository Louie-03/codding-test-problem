package acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No4344 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int length = scanner.nextInt();
            int[] ints = new int[length + 1];
            ints[0] = length;
            int sum = 0;

            for (int j = 1; j <= length; j++) {
                int num = scanner.nextInt();
                ints[j] = num;
            }

            list.add(ints);
        }

        for (int i = 0; i < n; i++) {
            int[] ints = list.get(i);

            int sum = 0;
            int length = ints[0];
            for (int j = 1; j <= length; j++) {
                sum += ints[j];
            }

            int avg = sum / length;
            int count = 0;
            for (int j = 1; j <= length; j++) {
                if (ints[j] > avg)
                    count++;
            }
            System.out.println(String.format("%.3f%%", ((float) count / length) * 100));
        }
    }
}
