package acmicpc.no1707;

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

public class Main {

    /*
     문제 : 이분 그래프
     유형 : BFS
     시간 복잡도 : O(?)
     난이도 : 매우 어려움
     시간 : 2h 30m
     uri : https://www.acmicpc.net/problem/1707
     날짜 : 22.12.15
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) { // K
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = 1; j <= v; j++) { // V
                map.put(j, new ArrayList<>());
            }
            int e = Integer.parseInt(st.nextToken());
            for (int j = 0; j < e; j++) { // E
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map.get(a).add(b);
                map.get(b).add(a);
            }
            boolean[] check = new boolean[v + 1];
            String result = bfs(1, v, map, check);
            for (int j = 1; j <= v; j++) {
                if (!check[j]) {
                    result = bfs(j, v, map, check);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static String bfs(int start, int v, Map<Integer, List<Integer>> map, boolean[] check) {
        Boolean[] booleans = new Boolean[v + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        booleans[start] = true;
        while (!queue.isEmpty()) { // E
            Integer integer = queue.poll();
            check[integer] = true;
            for (Integer integer1 : map.get(integer)) { // E
                if (booleans[integer1] == null) {
                    booleans[integer1] = !booleans[integer];
                    queue.add(integer1);
                    continue;
                }
                if (booleans[integer] == booleans[integer1]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
    /*
    1 5
    3 5

    1 5

    13 32 23
    1   O
    2   O
    3   X

    12 23 34 42
    1   O
    2   X
    3   O
    4   X
     */
}
