package inflearn.그리디.원더랜드프림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 원더랜드(최소스패닝트리)
     유형 : 최소 신장 트리(MST), Prim(프림) 알고리즘
     시간 복잡도 : O(N)
     난이도 : 보통
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/09-07
     날짜 : 22.11.6
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73418?tab=community
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int v = Integer.parseInt(strings[0]);
        int e = Integer.parseInt(strings[1]);
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(a).add(new Node(b, cost));
            map.get(b).add(new Node(a, cost));
        }
        boolean[] booleans = new boolean[v + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>(Collections.reverseOrder());
        booleans[1] = true;
        for (Node node : map.get(1)) {
            queue.add(node);
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!booleans[node.location]) {
                booleans[node.location] = true;
                answer += node.cost;
                for (Node node1 : map.get(node.location)) {
                    if (!booleans[node1.location]) {
                        queue.add(node1);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        int location;
        int cost;

        public Node(int location, int cost) {
            this.location = location;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return o.cost - cost;
        }
    }
}
