package acmicpc.no1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 케빈 베이컨의 6단계 법칙
     유형 : BFS
     시간 복잡도 : O(V(V+E))
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://www.acmicpc.net/problem/1389
     날짜 : 22.11.18
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int[][] dp = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        int e = Integer.parseInt(st.nextToken());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[a][b] = 1;
            dp[b][a] = 1;
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
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            int sum = 0;
            for (int j = 1; j <= v; j++) {
                sum += dp[i][j];
            }
            if (min > sum) {
                min = sum;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
