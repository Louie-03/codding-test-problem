package codeup;

import java.util.Scanner;

public class No1097 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] coordinate = new int[19][19];

        for (int i = 0; i < coordinate.length; i++) {
            for (int j = 0; j < coordinate[i].length; j++) {
                coordinate[i][j] = scanner.nextInt();
            }
        }

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            for (int j = 0; j < coordinate.length; j++) {
                if (coordinate[x][j] == 0) {
                    coordinate[x][j] = 1;
                } else {
                    coordinate[x][j] = 0;
                }
            }
            for (int j = 0; j < coordinate.length; j++) {
                if (coordinate[j][y] == 0) {
                    coordinate[j][y] = 1;
                } else {
                    coordinate[j][y] = 0;
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
