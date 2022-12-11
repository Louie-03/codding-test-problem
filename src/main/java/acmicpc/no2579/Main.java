package acmicpc.no2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    /*
     문제 : 계단 오르기
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 보통
     시간 : 1h 30
     uri : https://www.acmicpc.net/problem/2579
     날짜 : 22.12.6
     refer : https://st-lab.tistory.com/132
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }
        int[] ints = new int[n];
        Integer[] dp1 = new Integer[n];
        Integer[] dp2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }
        dp1[0] = dp2[0] = ints[0];
        dp1[1] = ints[0] + ints[1];
        dp2[1] = ints[1];
        for (int i = 2; i < n; i++) {
            dp1[i] = dp2[i - 1] + ints[i];
            dp2[i] = Math.max(dp1[i - 2], dp2[i - 2]) + ints[i];
        }
        System.out.println(Math.max(dp1[n - 1], dp2[n - 1]));
    }

    /*
    10 30 35 50 65 65

    10 20 25 55 45 75

    한 계단 또는 두 계단씩 오를 수 있다.
    연속된 세 개의 계단을 밟으면 안된다. -> 이걸 어떻게 처리해야될지 모르겠음
    마지막 계단은 반드시 밟아야 한다.

    바로 앞칸을 밟은 경우와 밟지 않은 경우를 둘 다 보관해야 될 것 같음

    10 x
    30 x
    35 10 + 15 or 20 + 15
    55 10 + 20 + 25 or 10 + 15 + 25
    75

    거꾸로 생각하면 N에서 N-2를 밟지 않은 dp[N-1]와 dp[N-2] 중에 무엇이 큰지 비교하면 될 것 같다.
    N-2를 밟지 않은 dp[N-1]은 dp[N-3] + arr[n-1] 이다.
    dp[N-3]은 max(dp[N-4], dp[N-5]) + arr[N-3]이다.

    dp[N-2]는 max(N-4를 밟지 않은 dp[N-3], dp[N-4]) + arr[N-2]이다.
    N-4를 밟지 않은 dp[N-3]은 dp[N-5] + arr[N-3]이다.
    dp[N-4]는 이미 초기화되어있다.

    max(N-4를 밟지 않은 dp[N-3], dp[N-4]) = max(25, 30)

    dp[N-2] = 30 + 25
    N-2를 밟지 않은 dp[N-1] = max(N-5를 밟지 않은 dp[N-4], dp[N-5]) + arr[N-3] + arr[N-1]
    N-2를 밟지 않은 dp[N-1] = max(20, 10) + arr[N-3] + arr[N-1]

     */
}
