package codeup;

import java.util.Scanner;

public class No1094 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        for (int i = ints.length - 1; i >= 0; i--) {
            System.out.print(ints[i] + " ");
        }
    }
}
