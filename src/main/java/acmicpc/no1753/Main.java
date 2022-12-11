package acmicpc.no1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 최단경로
     유형 : 다익스트라 알고리즘
     시간 복잡도 : O(ElogV)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://www.acmicpc.net/problem/1753
     날짜 : 22.11.11
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            map.get(Integer.parseInt(st.nextToken()))
                .add(new Node(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Node node : map.get(k)) {
            queue.add(node);
        }
        Map<Integer, Integer> costMap = new HashMap<>();
        costMap.put(k, 0);
        boolean[] check = new boolean[v + 1];
        check[k] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!check[node.destination]) {
                costMap.put(node.destination, node.cost);
                check[node.destination] = true;
                for (Node node1 : map.get(node.destination)) {
                    if (!check[node1.destination]) {
                        queue.add(new Node(node1.destination, node.cost + node1.cost));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            Integer integer = costMap.get(i);
            if (integer != null) {
                sb.append(integer).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {

        int destination;
        int cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }

        @Override
        public String toString() {
            return destination + " " + cost;
        }
    }
}
