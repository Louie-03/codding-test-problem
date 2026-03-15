package acmicpc.no17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    static int solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            int sqrt = (int) Math.sqrt(i);
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j <= sqrt; j++) {
                int squared = j * j;
                dp[i] = min(dp[i - squared] + 1, dp[i]);
            }
        }

        return dp[n];
    }

}
