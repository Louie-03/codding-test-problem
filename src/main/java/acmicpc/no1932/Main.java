package acmicpc.no1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 정수 삼각형
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 10m
     uri : https://www.acmicpc.net/problem/1932
     날짜 : 22.11.9
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][];
        for (int i = 0; i < n; i++) {
            ints[i] = new int[i + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                ints[i][j] += Math.max(ints[i + 1][j], ints[i + 1][j + 1]);
            }
        }
        System.out.println(ints[0][0]);
    }
}
