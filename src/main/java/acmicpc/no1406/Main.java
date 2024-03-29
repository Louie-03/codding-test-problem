package acmicpc.no1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 에디터
     유형 : 스택
     시간 복잡도 : O(N)
     난이도 : 조금 쉬움
     시간 : 30m
     uri : https://www.acmicpc.net/problem/1406
     날짜 : 22.12.12
     refer : https://minhamina.tistory.com/17
     */
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
        for (Character character : leftStack) {
            sb.append(character);
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
    /*
    왼쪽 스택은 뺄때마다 맨 뒤에 있는게 나온다.
    오른쪽 스택은 뺄때마다 맨 앞에 있는게 나온다.
     */
}
