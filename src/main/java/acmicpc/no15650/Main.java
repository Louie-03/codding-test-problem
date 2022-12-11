package acmicpc.no15650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : n과 m(2)
     유형 : 백트래킹
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/15650
     날짜 : 22.11.10
     refer :
     */
    static int n;
    static int m;
    static Stack<Integer> stack = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            dfs(i + 1);
            stack.pop();
        }
        bw.flush();
    }

    private static void dfs(int start) throws IOException {
        if (stack.size() == m) {
            for (Integer integer : stack) {
                bw.write(integer + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            stack.push(i);
            dfs(i + 1);
            stack.pop();
        }
    }
}
