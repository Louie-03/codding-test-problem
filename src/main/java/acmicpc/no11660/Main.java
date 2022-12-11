package acmicpc.no11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 구간 합 구하기 5
     유형 : 부분합
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/11660
     날짜 : 22.12.5
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] ints = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ints[i][j] =
                    ints[i][j - 1] + ints[i - 1][j] - ints[i - 1][j - 1]
                        + Integer.parseInt(st.nextToken());
            }
        }
        int[][] ints1 = new int[m][4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                ints1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints2 : ints1) {
            int sum = ints[ints2[2]][ints2[3]] - ints[ints2[0] - 1][ints2[3]]
                - ints[ints2[2]][ints2[1] - 1] + ints[ints2[0] - 1][ints2[1] - 1];
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}
