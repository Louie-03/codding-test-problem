package acmicpc.no1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 피보나치 함수
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://www.acmicpc.net/problem/1003
     날짜 : 22.11.9
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        int max = 2;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            ints[i] = num;
            max = Math.max(max, num);
        }

        int[][] dp = new int[max + 1][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        for (int anInt : ints) {
            sb.append(dp[anInt][0] + " " + dp[anInt][1] + "\n");
        }
        System.out.println(sb);
    }
    /*
    앞 = 전 뒤
    뒤 = 전 앞 + 뒤
     */
}
