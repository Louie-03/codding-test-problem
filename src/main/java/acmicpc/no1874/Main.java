package acmicpc.no1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append('\n');
            while (!stack.empty() && stack.peek() == list.get(index)) {
                stack.pop();
                sb.append("-").append('\n');
                index++;
            }
        }
        if (answer.size() == n) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
    /*
    1 2 3 4
    1 2 3   4
    1 2   4 3
    1 2 5   4 3
    1 2 5 6   4 3
    1 2 5     4 3 6
    1 2 5 7 8     4 3 6
    4 3 6 8 7 5 2 1
     */
}
