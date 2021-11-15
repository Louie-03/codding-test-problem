package codeup;

import java.util.Scanner;

public class No1093 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[23];

        for (int i = 0; i < n; i++) {
            ints[scanner.nextInt() - 1]++;
        }
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
