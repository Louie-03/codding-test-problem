package inflearn.DP.가장높은탑쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 가장 높은 탑 쌓기
     유형 : DP
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 10m
     uri : https://cote.inflearn.com/contest/10/problem/10-04
     날짜 : 22.11.9
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73423?tab=curriculum
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ints[i][0] = Integer.parseInt(st.nextToken());
            ints[i][1] = Integer.parseInt(st.nextToken());
            ints[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints, (ints1, ints2) -> {
            if (ints1[0] == ints2[0]) {
                return ints1[2] - ints2[2];
            }
            return ints1[0] - ints2[0];
        });
        int[] dp = new int[n];
        dp[0] = ints[0][1];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (ints[j][2] < ints[i][2]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + ints[i][1];
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
    /*
    아래의 두 조건 모두 만족해야하기 때문에 한 조건으로 정렬하고 남은 한 조건은 조건문으로 검사하면 된다.

    위에 있는 벽돌이 아래에 있는 벽돌보다 넓이가 더 좁아야함
    위에 있는 벽돌이 아래에 있는 벽돌보다 무게가 더 낮아야함

    25 3 4  3
    9 2 3   5
    1 5 2   10

    넓이 또는 무게가 같은 벽돌은 없음

    높이는 같을 수도 있음
     */
}
