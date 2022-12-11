package inflearn.스택큐.후위식연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class Main {

    /*
     문제 : 후위식 연산
     유형 : 스택
     시간 복잡도 : O(N)
     난이도 : 조금 어려움
     시간 : 70m
     uri : https://cote.inflearn.com/contest/10/problem/05-04
     날짜 : 22.10.10
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Stack<Integer> operands = new Stack<>();
        Map<Character, BinaryOperator<Integer>> map = new HashMap<>();
        map.put('+', (a, b) -> a + b);
        map.put('-', (a, b) -> a - b);
        map.put('*', (a, b) -> a * b);
        map.put('/', (a, b) -> a / b);
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('0' <= c && c <= '9') {
                operands.push(c - '0');
            } else {
                Integer num1 = operands.pop();
                Integer num2 = operands.pop();
                operands.push(map.get(c).apply(num2, num1));
            }
        }
        System.out.println(operands.pop());
    }
}
