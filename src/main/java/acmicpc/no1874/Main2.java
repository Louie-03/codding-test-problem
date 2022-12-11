package acmicpc.no1874;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        ArrayList<String> ans = new ArrayList();
        int n = sc.nextInt();
        int[] a = new int[n + 1]; // 0을 사용하지 않기 때문에 +1을 해줌
        int m = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            ans.add("+");
            while (!stack.empty() && stack.peek() == a[m]) {
                stack.pop();
                ans.add("-");
                m++;
            }
        }

        if (stack.empty()) {
            for (String s : ans) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }

    }
}
