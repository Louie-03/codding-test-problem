package acmicpc.no2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        System.out.println(DP(string));
    }

    static int DP(String string) {
        if (string.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[string.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= string.length(); i++) {

            dp[i - 1] %= 1000000;

            char now = string.charAt(i - 1);
            char before = string.charAt(i - 2);

            if (now == '0') {
                if (!isCanMakeAlphabet(now, before)) {
                    return 0;
                }
                dp[i] = dp[i - 2];
                continue;
            }

            dp[i] = dp[i - 1];
            if (isCanMakeAlphabet(now, before)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[string.length()];
    }

    static boolean isCanMakeAlphabet(char now, char before) {
        return before != '0' && (before - '0') * 10 + (now - '0') <= 26;
    }
    /*
    암호가 잘못된 경우가 어느 상황에 존재하는지?
    첫번째 글자가 0일때 0은 알파벳으로 변경하지 못하기 때문에 잘못된 숫자이다.
    그리고 앞글자가 3 이상인데 현재 글자가 0이라면 숫자 30은 알파벳으로 변경하지 못하기 때문에 잘못된 암호다.
    또는 앞글자가 0이고 현재 글자가 0이라면 00은 알파벳으로 변경하지 못하기 때문에 잘못된 암호다.

    1004
    1024

    1   1

    10  1

    102 1
    10 2

    1024    2
    10 2 4
    10 24


    2   1

    25  2
    2 5
    25  <- 26보다 작으니까 가능

    251 2
    2 5 1
    25 1

    2511    4
    2 5 1 1
    25 1 1
    2 5 11
    25 11

    25114 6
    2 5 1 1 4
    25 1 1 4
    2 5 11 4
    25 11 4
    2 5 1 14
    25 1 14

    25114   6
    2 5 1 1 4   BEAAD
    2 5 11 4    BEKD
    2 5 1 14    BEAN
    25 1 1 4    YAAD
    25 11 4     YKD
    25 1 14     YAN


    1 2 4 8 11
    1   1
    1

    11  2   1 + DP[1] * DP[1]
    11
    1 1

    3
    1 2
    2 1
    111 4   1 + (DP[1] * DP[2]) * 2 - 1
    111
    11 1
    1 11
    1 1 1

    4
    1 3
    3 1
    2 2
    1111    8   1 + (DP[1] * DP[3]) * 2 + DP[2] * DP[2]
    1111        1 + 8 + 4 +
    111 1
    11 11
    11 1 1
    1 111
    1 11 1
    1 1 11
    1 1 1 1

    11111   16
    11111
    1111 1
    111 11
    111 1 1
    11 111
    11 11 1
    11 1 11
    11 1 1 1
    1 1111
    1 1 111
    1 111 1
    1 11 11
    1 11 1 1
    1 1 1 11
    1 1 11 1
    1 1 1 1 1

    111111  24
    111111
    11111 1
    1111 11
    1111 1 1
    111 111
    111 11 1
    111 1 11
    111 1 1 1
    11 1111
    11 111 1
    11 11 11
    11 11 1 1
    11 1 111
    11 1 11 1
    11 1 1 11
    11 1 1 1 1
    1 1 1111
    1 1 111 1
    1 1 11 11
    1 1 11 1 1
    1 1 1 111
    1 1 1 11 1
    1 1 1 1 11
    1 1 1 1 1 1
     */
}
