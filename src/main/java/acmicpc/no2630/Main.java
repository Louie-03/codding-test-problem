package acmicpc.no2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 색종이 만들기
     유형 : 분할 정복
     시간 복잡도 : O(N^2(LogN))
     난이도 : 매우 쉬움
     시간 : 30m
     uri : https://www.acmicpc.net/problem/2630
     날짜 : 22.12.2
     refer :
     */
    static boolean[][] booleans;
    static int n;
    static int whiteCount;
    static int blueCount;

    public static void main(String[] args) throws IOException {
        System.out.println(Math.log(16) / Math.log(2));
        System.out.println(Math.log(8) / Math.log(2));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        booleans = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                booleans[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        dfs(0, 0, n);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void dfs(int startX, int startY, int size) {
        if (isAllSameColor(startX, startY, size)) {
            if (booleans[startY][startX]) {
                blueCount++;
            } else {
                whiteCount++;
            }
            return;
        }

        int nextSize = size / 2;
        dfs(startX, startY, nextSize);
        dfs(startX, startY + nextSize, nextSize);
        dfs(startX + nextSize, startY, nextSize);
        dfs(startX + nextSize, startY + nextSize, nextSize);
    }

    private static boolean isAllSameColor(int startX, int startY, int size) {
        boolean color = booleans[startY][startX];
        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (color != booleans[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    /*
    모두 같은색인 경우 size 반환
    모두 같은색이 아닌경우 4개로 나눠서 재귀 실행

    0~8, 0~8    0, 0, 8
    0~4,0~4 / 0~4,4~8 / 4~8,0~4 / 4~8,4~8
    0, 0, 4 / 0, 4, 4 / 4, 0, 4 / 4, 4, 4
     */
}
