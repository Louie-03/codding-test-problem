package acmicpc.no1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    문제 : 쿼드트리
    유형 : 재귀, 분할 정복
    시간 복잡도 : O(N^2)
    난이도 : 조금 쉬움
    시간 : 45m
    uri : https://www.acmicpc.net/problem/1992
    날짜 : 22.11.21
    refer :
    */
    static StringBuilder answer = new StringBuilder();
    static int[][] ints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < n; j++) {
                ints[i][j] = string.charAt(j) - 48;
            }
        }
        recursive(0, 0, n);
        System.out.println(answer);
    }

    static void recursive(int startX, int startY, int size) {
        if (check(startX, startY, size, ints)) {
            answer.append(ints[startY][startX]);
            return;
        }

        answer.append('(');
        int newSize = size / 2;
        recursive(startX, startY, newSize);
        recursive(startX + newSize, startY, newSize);
        recursive(startX, startY + newSize, newSize);
        recursive(startX + newSize, startY + newSize, newSize);
        answer.append(')');
    }

    private static boolean check(int startX, int startY, int size, int[][] ints) {
        boolean flag = ints[startY][startX] == 1;
        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if ((flag && ints[i][j] == 0) || (!flag && ints[i][j] == 1)) {
                    return false;
                }
            }
        }
        return true;
    }


    /*
    0 ~ 4           4 ~ 8       (0, 0) (4, 4)
    0 ~ 2 2 ~ 4     4 ~ 6 6 ~ 8 (0,0) (2,2) / (2,0) (4,2) / (0,2) (2,4) / (2,2) (4,4)
                                (2,2) (3,3) / (3,2) (4,3) / (2,3) (3,4) / (3,3) (4,4)
    0 ~ 1 1 ~ 2 2 ~ 3 3 ~ 4
    나눠질때마다 괄호 하나씩 추가

     */
}
