package acmicpc.no1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 체스판 다시 칠하기
     유형 : 브루트포스 알고리즘
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://www.acmicpc.net/problem/1018
     날짜 : 22.11.7
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                chars[i][j] = string.charAt(j);
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                answer = Math.min(answer, getCount(chars, i, j));
            }
        }
        System.out.println(answer);
    }

    private static int getCount(char[][] chars, int i, int j) {
        int count = 0;
        boolean check = true;
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if ((check && chars[k][l] != 'W') || (!check && chars[k][l] != 'B')) {
                    count++;
                }
                check = !check;
            }
            check = !check;
        }
        return Math.min(count, 64 - count);
    }
}
