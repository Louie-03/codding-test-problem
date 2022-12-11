package acmicpc.no11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {
    public static void main(String args[]) throws IOException {
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
        for (int k = 1; k <= v; k++)
            for (int i = 1; i <= v; i++)
                for (int j = 1; j <= v; j++) {
                    if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue; // 0만나면 패스
                    if (dp[i][j] > dp[i][k] + dp[k][j]) // k를 거치는 경로가 더 짧으면 그 값으로 업데이트
                        dp[i][j] = dp[i][k] + dp[k][j];
                }

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }
}
/*
2 > 1
3 > 2
3 > 1 = 3 > 1 OR 3 > 2 > 1

3 > 1 = 3 > 5 > 1 OR 3 > 1

4 > 1 = 4 > 3 > 1
 */
