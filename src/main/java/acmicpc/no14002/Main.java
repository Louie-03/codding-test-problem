package acmicpc.no14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 가장 긴 증가하는 부분 수열 4
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 조금 어려움
     시간 : 1h
     uri : https://www.acmicpc.net/problem/14002
     날짜 : 22.12.26
     refer : https://juintination.tistory.com/entry/%EB%B0%B1%EC%A4%80-14002%EB%B2%88-%EA%B0%80%EC%9E%A5-%EA%B8%B4-%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4-4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lis(i, ints, dp));
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == max) {
                max--;
                stack.push(ints[i]);
            }
        }
        System.out.println(stack.size());

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static int lis(int index, int[] ints, int[] dp) {
        if (dp[index] == 0) {
            dp[index] = 1;
            for (int i = index - 1; i >= 0; i--) {
                if (ints[index] > ints[i]) {
                    dp[index] = Math.max(dp[index], lis(i, ints, dp) + 1);
                }
            }
        }
        return dp[index];
    }
    /*
    10 20 50 40 30
    1  2  3  3  3

    10 40 50 20 30
    1  2  3  2  3

       10 30 20 30 50
    10 1  2  2  2  2
    30 1  1  1  1  2
    20 1  2  1  2  2
    30 1  1  1  1  2
    50 1  1  1  1  1

       10 30 20 30 50
    10 1  2  2  2  2
    30 x  1  1  1  2
    20 x  x  1  2  2
    30 x  x  x  1  2
    50 x  x  x  x  1

       10 30 20 30 50
    10 1  2  2  3  4
    30 x  1  1  2  3
    20 x  x  1  2  3
    30 x  x  x  1  2
    50 x  x  x  x  1

       10 20 30 50
    10
    20 x  1  2  3
    30 x  x  1  1
    50 x  x  x  1

       10 20 30 20 50
    10 1  2  3  3  4
    20 x  1  2  2  3
    30 x  x  1  1  2
    20 x  x  x  1  2
    50 x  x  x  x  1

    자기보다 작은 경우 실제 개수는 1이지만 최대 개수는 2이므로 최근에 계산했던 값을 그대로 넣는다
    -> 이렇게 할려면 최근에 갱신된 가지고 있어야함

    10 30 20 30 50

    10
    10 30
    10 30 or 10 20
    10 20 30
    10 20 30 50

    11111
    12222


      1000
    0
    1
    2
    3
    4
    5

    10 20 10 30 20 50

    1
    10

    2
    10 20

    3
    10 20

    4
    10 20 30

    5
    10 20 30

    6
    10 20 30 50

    10 30 10 20 10 30 20 50

    10
    10 30
    ;;
    10 30 or 10 20
    ;;
    10 20 30
    10 20 30
    10 20 30 50

     */
}
