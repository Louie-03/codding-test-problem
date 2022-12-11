package acmicpc.no11403;

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
     문제 : 경로 찾기
     유형 : 플로이드 와샬
     시간 복잡도 : O()
     난이도 : 매우 쉬움
     시간 : 10m
     uri : https://www.acmicpc.net/problem/11724
     날짜 : 22.11.11
     refer :
     */
    static boolean[][] booleans;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        booleans = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (st.nextToken().equals("1")) {
                    map.get(i).add(j);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (booleans[i][j]) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        boolean[] check = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer integer = queue.poll();
                for (Integer integer1 : map.get(integer)) {
                    if (!check[integer1]) {
                        check[integer1] = true;
                        booleans[start][integer1] = true;
                        queue.add(integer1);
                    }
                }
            }
        }
    }
}
