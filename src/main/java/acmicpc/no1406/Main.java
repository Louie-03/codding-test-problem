package acmicpc.no1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            leftStack.push(string.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("L") && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            if (command.equals("D") && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
            if (command.equals("B") && !leftStack.isEmpty()) {
                leftStack.pop();
            }
            if (command.equals("P")) {
                leftStack.push(st.nextToken().charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
    }
}
