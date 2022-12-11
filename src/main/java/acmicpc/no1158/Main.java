package acmicpc.no1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 요세푸스 문제
     유형 : 큐
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/1158
     날짜 : 22.12.12
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll());
        sb.append(">");
        System.out.println(sb);
    }
    /*
    1 2 3 4 5 6 7
    4 5 6 7 1 2
    7 1 2 4 5
    7 1 2 4 5
     */
}
