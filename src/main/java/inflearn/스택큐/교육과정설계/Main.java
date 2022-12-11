package inflearn.스택큐.교육과정설계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /*
     문제 : 교육과정 설계
     유형 : 큐
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://cote.inflearn.com/contest/10/problem/05-07
     날짜 : 22.10.12
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = br.readLine().toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char c : chars1) {
            queue.add(c);
        }
        char[] chars2 = br.readLine().toCharArray();
        for (char c : chars2) {
            if (queue.isEmpty()) {
                break;
            }
            if (c == queue.peek()) {
                queue.poll();
            }
        }

        if (queue.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
