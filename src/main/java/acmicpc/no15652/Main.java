package acmicpc.no15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : N과 M (4)
     유형 : 백트래킹
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 10m
     uri : https://www.acmicpc.net/problem/15652
     날짜 : 22.11.11
     refer :
     */
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            dfs(stack);
            stack.pop();
        }
        System.out.println(sb);
    }

    private static void dfs(Stack<Integer> stack) {
        if (stack.size() == m) {
            for (Integer integer : stack) {
                sb.append(integer + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = stack.peek(); i <= n; i++) {
            stack.push(i);
            dfs(stack);
            stack.pop();
        }
    }
}
