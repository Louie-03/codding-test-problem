package acmicpc.no1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : RGB거리
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 30m
     uri : https://www.acmicpc.net/problem/1149
     날짜 : 22.11.9
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ints[i][0] = Integer.parseInt(st.nextToken());
            ints[i][1] = Integer.parseInt(st.nextToken());
            ints[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][3];
        dp[0][0] = ints[0][0];
        dp[0][1] = ints[0][1];
        dp[0][2] = ints[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = ints[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = ints[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = ints[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}
