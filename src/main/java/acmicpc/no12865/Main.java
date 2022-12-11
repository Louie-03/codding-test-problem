package acmicpc.no12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 평범한 배낭
     유형 : DP
     시간 복잡도 : O(NK) N = 배낭 개수, K = 최대 무게
     난이도 : 매우 어려움
     시간 : 2h
     uri : https://www.acmicpc.net/problem/12865
     날짜 : 22.11.11
     refer : https://st-lab.tistory.com/141
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weights[i]) {
                    dp[i][j] = Math.max(dp[i][j], values[i]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
