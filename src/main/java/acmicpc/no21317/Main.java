package acmicpc.no21317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] smallJumps = new int[n];
        int[] bigJumps = new int[n];
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            smallJumps[i] = Integer.parseInt(st.nextToken());
            bigJumps[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        System.out.println(solution(n, smallJumps, bigJumps, k));
    }

    static int solution(int n, int[] smallJumps, int[] bigJumps, int k) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return smallJumps[1];
        }
        int[] dp = new int[n + 1];
        dp[2] = smallJumps[1];
        dp[3] = min(smallJumps[1] + smallJumps[2], bigJumps[1]);
        if (n == 3) {
            return dp[n];
        }

        int[] kDp = new int[n + 1];
        kDp[4] = k;
        for (int i = 4; i <= n; i++) {
            dp[i] = min(dp[i - 1] + smallJumps[i - 1], dp[i - 2] + bigJumps[i - 2]);
        }

        for (int i = 5; i <= n; i++) {
            kDp[i] = getKDpMin(smallJumps, bigJumps, k, kDp, i, dp);
        }

        return min(dp[n], kDp[n]);
    }

    private static int getKDpMin(int[] smallJumps, int[] bigJumps, int k, int[] kDp, int i, int[] dp) {
        if (i == 5) {
            return min(kDp[i - 1] + smallJumps[i - 1], dp[i - 3] + k);
        }
        return min(min(kDp[i - 2] + bigJumps[i - 2], kDp[i - 1] + smallJumps[i - 1]), dp[i - 3] + k);
    }

    /**
     * 1 2 3 4 5
     * 1 2 4 6
     * 2 3 5 7
     *
     * 2 1s
     * 3 1s2s 1b
     * 4 1s2b 1b3s 1s2s3s
     *
     * 1->2 : 1
     * 2->5 : 4(k)
     *
     *
     * 매우 큰 점프를 사용하지 않고 작은 점프, 큰 점프로만 점수가 계산된 dp배열
     * 매우 큰 점프를 이미 사용한 dp배열
     * 두 배열을 따로 관리해서 최종 답을 구하면 됨
     *
     */
}
