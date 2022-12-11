package acmicpc.no2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /*
    문제 : 카드2
    유형 : Queue
    시간 복잡도 : O(N)
    난이도 : 매우 쉬움
    시간 : 10m
    uri : https://www.acmicpc.net/problem/2164
    날짜 : 22.11.22
    refer :
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
