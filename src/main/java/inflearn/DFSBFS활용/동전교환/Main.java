package inflearn.DFSBFS활용.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 동전교환
     유형 : BFS
     시간 복잡도 : O(N^M)
     난이도 : 쉬움
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/08-05
     날짜 : 22.10.18
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73400?category=questionDetail&tab=community
     */
    static int m;
    static int[] ints;
    static boolean[] booleans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        booleans = new boolean[m + 1];
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int anInt : ints) {
            queue.add(anInt);
            booleans[anInt] = true;
        }
        int L = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer num = queue.poll();
                if (num == m) {
                    return L;
                }
                for (int anInt : ints) {
                    int sum = num + anInt;
                    if (m >= sum && !booleans[sum]) {
                        booleans[num] = true;
                        queue.add(sum);
                    }
                }
            }
            L++;
        }
        return -1;
    }
}
