package acmicpc;

import java.util.Scanner;

public class No2178 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edge = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            int num = scanner.nextInt();
            for (int j = m; j >= 1; j--) {
                edge[i][j] = num % 10;
                num /= 10;
            }
        }

        int i = 1;
        int j = 1;
        int count = 0;
        while (i != n && j != m) {
            count++;
            int x = 0;
            int y = 0;
            x = i + 1 == n ? 0 : edge[i][j + 1];
            y = j + 1 == m ? 0 : edge[i + 1][j];

            if (x == 1 && y == 1) {

            }else if (x == 1 && y != 1) {
                i++;
            }else {
                j++;
            }
        }
    }
}
