package inflearn.스택큐.괄호문자제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    /**
     * 문제 : 괄호문자제거
     * 유형 : 스택
     * 시간 복잡도 : O(N)
     * 난이도 : 쉬움
     * 시간 : 5m
     * uri : https://cote.inflearn.com/contest/10/problem/05-02
     * 날짜 : 22.10.10
     * refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (Character.isAlphabetic(c) && stack.isEmpty()) {
                sb.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                stack.pop();
            }
        }
        System.out.println(sb);
    }
}
