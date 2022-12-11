package acmicpc.no11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainBFS {

    /*
     문제 : 연결 요소의 개수
     유형 : BFS
     시간 복잡도 : O(V+E)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://www.acmicpc.net/problem/11724
     날짜 : 22.11.11
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        boolean[] booleans = new boolean[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!booleans[i]) {
                answer++;
                bfs(map, booleans, i);
            }
        }
        System.out.println(answer);
    }

    private static void bfs(Map<Integer, List<Integer>> map, boolean[] booleans, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        booleans[i] = true;
        while (!queue.isEmpty()) {
            for (Integer integer : map.get(queue.poll())) {
                if (!booleans[integer]) {
                    queue.add(integer);
                    booleans[integer] = true;
                }
            }
        }
    }
}
