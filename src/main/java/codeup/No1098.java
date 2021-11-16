package codeup;

import java.util.Scanner;

public class No1098 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[][] coordinate = new int[h][w];

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int d = scanner.nextInt();
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            if (d == 0) {
                for (int j = 0; j < l; j++) {
                    coordinate[x][y++] = 1;
                }
            } else {
                for (int j = 0; j < l; j++) {
                    coordinate[x++][y] = 1;
                }
            }
        }

        for (int[] ints : coordinate) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
