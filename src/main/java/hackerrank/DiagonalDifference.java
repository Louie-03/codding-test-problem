package hackerrank;

import java.util.Scanner;

public class DiagonalDifference {

    public static int diagonalDifference(int[][] square) {
        return Math.abs(getPrimaryDiagonalSum(square) - getSecondaryDiagonal(square));
    }

    private static int getPrimaryDiagonalSum(int[][] square) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][i];
        }
        return sum;
    }

    private static int getSecondaryDiagonal(int[][] square) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][square.length - 1 - i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = sc.nextInt();
            }
        }
        System.out.println(DiagonalDifference.diagonalDifference(square));
    }
}
