package acmicpc.no9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 파도반 수열
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://www.acmicpc.net/problem/9461
     날짜 : 22.11.20
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, ints[i]);
        }
        long[] dp = new long[max + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= max; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }
        StringBuilder sb = new StringBuilder();
        for (int anInt : ints) {
            sb.append(dp[anInt] + "\n");
        }
        System.out.println(sb);
    }
}
