package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FloydWarshall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] dp = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dp[start][end] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    if (dp[j][i] == Integer.MAX_VALUE || dp[i][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }
        printArray(dp);
    }

    private static void printArray(int[][] dp) {
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
/*
4 7
1 2 5
1 4 8
2 1 7
2 3 9
3 1 2
3 4 4
4 3 3

4 -> 1 -> 2 -> 3
4 -> 3 -> 2 -> 1
4 -> 2 -> 3 -> 1

2 -> 3, 2 -> 1 + 1 -> 3
1
1, 1 ~ 4
1 ~ 4, 1
i == j

2, 1 ~ 4
1 ~ 4, 2
i == j
 */
