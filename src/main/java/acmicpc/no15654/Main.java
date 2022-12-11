package acmicpc.no15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints);
        StringBuilder sb = new StringBuilder();
        dfs(size, new Stack<>(), new boolean[10001], ints, sb, n);
        System.out.println(sb);
    }

    private static void dfs(int size, Stack<Integer> stack, boolean[] check,
        int[] ints, StringBuilder sb, int n) {
        if (stack.size() == size) {
            for (Integer integer : stack) {
                sb.append(integer + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            int anInt = ints[i];
            if (!check[anInt]) {
                stack.push(anInt);
                check[anInt] = true;
                dfs(size, stack, check, ints, sb, n);
                stack.pop();
                check[anInt] = false;
            }
        }
    }
}
