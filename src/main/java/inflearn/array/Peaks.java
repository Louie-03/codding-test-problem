package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Peaks {

    static int[][] ints;
    static int[][] directions = initDirections();

    //    10. 봉우리 https://cote.inflearn.com/contest/10/problem/02-10
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ints = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isPeaks(i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isPeaks(int i, int j) {
        int num = ints[i][j];
        for (int[] direction : directions) {
            if (num <= ints[i + direction[0]][j + direction[1]]) {
                return false;
            }
        }
        return true;
    }

    private static int[][] initDirections() {
        return new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
    }
}
