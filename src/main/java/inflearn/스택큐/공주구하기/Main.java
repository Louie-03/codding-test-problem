package inflearn.스택큐.공주구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /*
     문제 : 공주 구하기
     유형 : 큐
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://cote.inflearn.com/contest/10/problem/05-06
     날짜 : 22.10.12
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        System.out.println(queue.peek());
    }
}
