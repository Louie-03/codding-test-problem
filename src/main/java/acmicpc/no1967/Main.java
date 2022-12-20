package acmicpc.no1967;

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
     문제 :
     유형 :
     시간 복잡도 : O(N)
     난이도 :
     시간 : m
     uri : https://www.acmicpc.net/problem/1967
     날짜 : 22.12.17
     refer :
     */
    static Map<Integer, List<Node>> map = new HashMap<>();
    static boolean[] visited;
    static int answer;
    static int endDestination = 1;

    public static void main(String[] args) throws IOException {
        init();

        visited[1] = true;
        dfs(1, 0);
        visited[1] = false;

        visited[endDestination] = true;

        dfs(endDestination, 0);
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(a).add(new Node(b, cost));
            map.get(b).add(new Node(a, cost));
        }
    }

    static class Node {
        int destination;
        int cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    private static void dfs(int num, int cost) {
        if (answer < cost) {
            answer = cost;
            endDestination = num;
        }
        for (Node node : map.get(num)) {
            if (!visited[node.destination]) {
                visited[node.destination] = true;
                dfs(node.destination, cost + node.cost);
                visited[node.destination] = false;
            }
        }
    }
}
