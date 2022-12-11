package inflearn.스택큐.쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    /*
     문제 : 쇠막대기
     유형 : 스택
     시간 복잡도 : O(N)
     난이도 : 조금 쉬움
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/05-05
     날짜 : 22.10.10
     refer :
     */

    /*
    총 점선의 개수 + 모든 레이저 위에 있는 선의 개수 총합
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                if (chars[i + 1] == '(') {
                    count++;
                }
                stack.push('(');
            } else {
                stack.pop();
                if (chars[i - 1] == '(') {
                    count += stack.size();
                }
            }
        }
        System.out.println(count);
    }
}
