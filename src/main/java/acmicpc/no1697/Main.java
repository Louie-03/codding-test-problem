package acmicpc.no1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 숨바꼭질
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 보통
     시간 : 1h
     uri : https://www.acmicpc.net/problem/1697
     날짜 : 22.11.9
     refer : https://velog.io/@lifeisbeautiful/%EB%B0%B1%EC%A4%80-1697%EB%B2%88-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88-DP-Java-Kotlin
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n >= k) {
            System.out.println(n - k);
            return;
        }
        int[] dp = new int[k + 2];
        Arrays.fill(dp, -1);
        dp[n] = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = n - i;
        }
        for (int i = n + 1; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i / 2] + i % 2) + 1;
            dp[i - 1] = Math.min(dp[i] + 1, dp[i - 1]);
        }
        for (int i = n; i < dp.length; i++) {
            System.out.println(i + " " + dp[i]);
        }
        System.out.println(dp[k]);
    }
    /*
    x - 1도 생각해야하기 때문에 max + 2로 정해줌
    동생이 내 앞쪽에 있는 경우
    0 1
    1 1
    2 1

    -1
    +1
    *2

     */
}
