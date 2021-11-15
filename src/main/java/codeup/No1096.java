package codeup;

import java.util.Scanner;

public class No1096 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] coordinate = new int[19][19];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            coordinate[x][y] = 1;
        }

        for (int[] ints : coordinate) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
