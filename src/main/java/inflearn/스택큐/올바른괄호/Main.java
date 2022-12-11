package inflearn.스택큐.올바른괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    /**
     * 1. 올바른 괄호
     * 스택
     * O(N)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        String result = "YES";
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    result = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            result = "NO";
        }

        System.out.println(result);
    }
}
