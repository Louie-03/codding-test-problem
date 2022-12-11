package inflearn.DP.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 계단오르기
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://cote.inflearn.com/contest/10/problem/10-01
     날짜 : 22.11.6
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73421?tab=curriculum&category=questionDetail
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

    /*
    1       1
    1

    2       2
    1 1
    2

    3       3
    1 1 1
    1 2
    2 1

    4       5
    1 1 1 1
    1 1 2
    1 2 1
    2 1 1
    2 2

    5       8
    1 1 1 1 1
    1 1 1 2
    1 1 2 1
    1 2 1 1
    2 1 1 1
    1 2 2
    2 1 2
    2 2 1

     */
}
