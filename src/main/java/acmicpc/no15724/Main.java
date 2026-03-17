package acmicpc.no15724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] ints = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = ints[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + ints[i][0];
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + ints[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + ints[i][j];
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == 1 && y1 == 1) {
                sb.append(dp[x2 - 1][y2 - 1]);
            } else if (x1 == 1) {
                sb.append(dp[x2 - 1][y2 - 1] - dp[x2 - 1][y1 - 2]);
            } else if (y1 == 1) {
                sb.append(dp[x2 - 1][y2 - 1] - dp[x1 - 2][y2 - 1]);
            } else {
                sb.append(dp[x2 - 1][y2 - 1] - dp[x1 - 2][y2 - 1] - dp[x2 - 1][y1 - 2]
                    + dp[x1 - 2][y1 - 2]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    /**
     * 9  14 29 7
     * 1  31 6  13
     * 21 26 40 16
     * 8  38 11 23
     *
     * 9  23  52  59
     * 10 55  90  110
     * 31 102 177 213
     * 39 148 234 293
     *
     * 1/2 = 1/1 + 0/2 - 0/1 + ints[1][2]
     *
     * 1132 [2][1]
     * 2233
     * 2334 = 75 = 213 - 59 - 102 + 23 = [2][3] - [0][3] - [2][1] + [0][1]
     *                                 = [x2 - 1][y2 - 1] - [x1-2][y2-1] - [x2-1][y1-2] + [x1-2][y1-2]
     * 1234 = 182
     */

    // TODO: 2026/03/16 1111인 경우
    // TODO: 2026/03/16 2222인 경우
    // TODO: 2026/03/16 nnmm인 경우
    // TODO: 2026/03/16 11로 시작하지 않는 경우
}
