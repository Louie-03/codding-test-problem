package acmicpc.no11576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : Base Conversion
     유형 : 구현, 수학
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 10m
     uri : https://www.acmicpc.net/problem/11576
     날짜 : 22.12.13
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int sum = getSum(a, n, ints);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = getStack(sum, b);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            sb.append(sum / pop).append(" ");
            sum %= pop;
        }
        System.out.println(sb);
    }

    private static int getSum(int a, int n, int[] ints) {
        int num = 1;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += num * ints[i];
            num *= a;
        }
        return sum;
    }

    private static Stack<Integer> getStack(int sum, int b) {
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        while (num <= sum) {
            stack.push(num);
            num *= b;
        }
        return stack;
    }
}
