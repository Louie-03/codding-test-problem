package acmicpc.no2579;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(n, ints));
    }

    static int solution(int n, int[] ints) {
        if (n == 1) {
            return ints[0];
        }
        if (n == 2) {
            return ints[0] + ints[1];
        }
        if (n == 3) {
            return max(ints[0], ints[1]) + ints[2];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = dp2[0] = ints[0];
        dp1[1] = ints[1];
        dp2[1] = ints[0] + ints[1];
        dp1[2] = ints[0] + ints[2];
        dp2[2] = ints[1] + ints[2];

        for (int i = 3; i < n; i++) {
            dp1[i] = ints[i] + max(dp1[i - 2], dp2[i - 2]);

            dp2[i] = ints[i] + ints[i - 1] + max(dp1[i - 3], dp2[i - 3]);
        }

        return max(dp1[n - 1], dp2[n - 1]);

        /**
         * dp1 vs dp2 : dp1는 i값만 포함(계단 1칸 건너뜀) dp2는 i와 i-1 값을 함께 포함(계단 2칸 연속 밟음)
         * TC  25 29 14 2  9  17 16
         * dp1 25 29 39 56 52 73 81
         * dp2 25 54 43 41 65 69 89
         */
    }
}
