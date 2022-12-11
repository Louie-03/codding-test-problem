package inflearn.DP.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 501);
        dp[0] = 0;
        for (int i : ints) {
            for (int j = i; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - i] + 1);
            }
        }
        System.out.println(dp[m]);
    }
    /*
        1 2 3 4 5 6 7 8 9 10
        1 1 2 2 1 2 2 3 3 2
5
1 8 20 25 50
129

반례
5
1 20 8 25 50
129

5
20 8 25 50 1
129

1 8 20 50 50
     */
}
