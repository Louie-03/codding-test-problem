package acmicpc.no2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[2] = 3;
        dp[4] = 11;
    }
    /*
    2   3
    --   ||   --
    --   ||   ||
    --   --   ||

    4   DP[N - 2] * 3 + 2 = 11
    6   DP[N - 2] * 3 + DP[N - 4] * 2 + DP[N - 6] * 2 = 41
    8   DP[N - 2] * 3 + 2 + 3 * 2 + DP
    ----    --||    ----
    ----    --||    --||
    ----    ----    --||

    ||--    ||||    ||--
    ||--    ||||    ||||
    ----    ----    --||

    ----    --||    ----
    ||--    ||||    ||||
    ||--    ||--    ||||

    ----   +  DP[2]
    |--|
    |--|

    |--|
    |--|
    ----

    dp[4] * dp[2] = 33
           +
       3 * 2 = 6
   dp[2] *  ----
            |--|
            |--|

            |--|
            |--|
            ----
           + 2
           = 41
       ------
       |----|
       |----|

       |----|
       |----|
       ------

    3^3 + 2 * 2 * 3 = 39

    3^4 + 2 * 2 * dp[4] - 2

    6
    ------    ----||    ------
    ------    ----||    ----||
    ------    ------    ----||

    --||--    --||||    --||--
    --||--    --||||    --||||
    ------    ------    ----||

    ------    ----||    ------
    --||--    --||||    --||||
    --||--    --||--    --||||

    -||---  -||-||    -||---
    -||---  -||-||    -||-||
    ------  ------    ----||

    ------  ----||    ------
    -||---  -||-||    -||-||
    -||---  -||---    -||-||

    홀수면 칸을 다 채울수가 없는데 0으로 출력하면 되는건지?
     */
}
