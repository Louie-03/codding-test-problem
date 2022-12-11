package acmicpc.no9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : N-Queen
     유형 : DP
     시간 복잡도 : O(N!)
     난이도 : 조금 어려움
     시간 : 1h
     uri : https://www.acmicpc.net/problem/9663
     날짜 : 22.11.10
     refer : https://st-lab.tistory.com/118
     */
    static int n;
    static int answer;
    static int[] ints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ints = new int[n];
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(depth, i)) {
                ints[depth] = i;
                dfs(depth + 1);
            }
        }
    }

    private static boolean check(int depth, int x) {
        for (int i = 0; i < depth; i++) {
            if (ints[i] == x || Math.abs(depth - i) == Math.abs(ints[i] - x)) {
                return false;
            }
        }
        return true;
    }
    /*
    배열의 인덱스 : y좌표
    배열의 값 : x좌표

     */
}
