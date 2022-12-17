package acmicpc.no1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 트리의 지름
     유형 : DFS
     시간 복잡도 : O(?)
     난이도 : 보통
     시간 : 1h
     uri : https://www.acmicpc.net/problem/1167
     날짜 : 22.12.17
     refer :
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = Integer.MIN_VALUE;
    static int endNode;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Point>> map = initMap(n);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, visited, map, 0);
        visited[1] = false;

        visited[endNode] = true;
        dfs(endNode, visited, map, 0);
        visited[endNode] = false;

        System.out.println(answer);
    }

    private static Map<Integer, List<Point>> initMap(int n) throws IOException {
        Map<Integer, List<Point>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Point> list = map.get(Integer.parseInt(st.nextToken()));
            String token = st.nextToken();
            while (!token.equals("-1")) {
                list.add(new Point(Integer.parseInt(token), Integer.parseInt(st.nextToken())));
                token = st.nextToken();
            }
        }
        return map;
    }

    static void dfs(int num, boolean[] visited, Map<Integer, List<Point>> map, int cost) {
        if (answer < cost) {
            answer = cost;
            endNode = num;
        }
        for (Point point : map.get(num)) {
            if (!visited[point.destination]) {
                visited[point.destination] = true;
                dfs(point.destination, visited, map, cost + point.cost);
                visited[point.destination] = false;
            }
        }
    }

    static class Point {

        int destination;
        int cost;

        public Point(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

    }
    /*
      2
    1 - 3

      4
    2 - 4

      3
    3 - 4

      6
    4 - 5

      2  +  3  + 6 = 11
    1 -> 3 -> 4 -> 5
     */
}
