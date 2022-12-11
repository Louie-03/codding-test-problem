package acmicpc.no11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    /*
    문제 : 최대 힙
    유형 : 우선순위 큐
    시간 복잡도 : O(NlogN)
    난이도 : 매우 쉬움
    시간 : 10m
    uri : https://www.acmicpc.net/problem/11279
    날짜 : 22.11.22
    refer :
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int anInt : ints) {
            if (anInt == 0) {
                sb.append(queue.isEmpty() ? 0 : queue.remove());
                sb.append('\n');
                continue;
            }
            queue.add(anInt);
        }
        System.out.println(sb);
    }
}
