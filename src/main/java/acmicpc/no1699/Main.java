package acmicpc.no1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 제곱수의 합
     유형 : DP
     시간 복잡도 : O(N sqrt(N))
     난이도 : 보통
     시간 : 1h
     uri : https://www.acmicpc.net/problem/1699
     날짜 : 22.12.6
     refer : https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-1699%EB%B2%88-%EC%A0%9C%EA%B3%B1%EC%88%98%EC%9D%98-%ED%95%A9-Java-%EC%9E%90%EB%B0%94
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
    }
    /*
    n - 9 + 9
    n - 4 + 4

    99
    81 18
    64 35
    49 50
    36 63

    13
    12 1
    9 4
    4 9

    15
    9 6 4


    dp[5] = dp[4] + dp[1]
    dp[11] = dp[9] + dp[2]

    81  18  9 2

    1 4 9 16 25 36 49 64 81

    4 8 12 16
     */
}
