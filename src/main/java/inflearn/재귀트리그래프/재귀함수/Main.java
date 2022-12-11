package inflearn.재귀트리그래프.재귀함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 재귀함수
     유형 : 재귀
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri :
     날짜 : 22.10.13
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i = Integer.parseInt(br.readLine());
        recursive(i, sb, i);
        System.out.println(sb);
    }

    private static void recursive(int i, StringBuilder sb, int num) {
        if (0 != num) {
            recursive(i, sb, num - 1);
            sb.append(num + " ");
        }
    }
}
