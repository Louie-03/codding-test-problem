package acmicpc.no13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 숨바꼭질 3
     유형 : BFS
     시간 복잡도 : ?
     난이도 : 매우 쉬움
     시간 : 50m
     uri : https://www.acmicpc.net/problem/13549
     날짜 : 22.12.2
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        boolean[] check = new boolean[100001];
        check[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int count = 0;
        while (!queue.isEmpty()) {
            teleport(check, queue);

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer integer = queue.poll();
                if (integer == k) {
                    return count;
                }
                if (integer != 100000 && !check[integer + 1]) {
                    queue.add(integer + 1);
                    check[integer + 1] = true;
                }
                if (integer != 0 && !check[integer - 1]) {
                    queue.add(integer - 1);
                    check[integer - 1] = true;
                }
            }
            count++;
        }
        throw new IllegalStateException();
    }

    private static void teleport(boolean[] check, Queue<Integer> queue) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Integer integer = queue.poll();
            queue.add(integer);
            int num = integer * 2;
            while (num <= 100000) {
                if (check[num]) {
                    break;
                }
                queue.add(num);
                check[num] = true;
                num *= 2;
            }
        }
    }
    /*
    0   5 10 20 40...
    1   4 5 6 8 10 12 16 20 24 32 40
    2
     */
}
