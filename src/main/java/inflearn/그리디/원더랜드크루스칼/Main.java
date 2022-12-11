package inflearn.그리디.원더랜드크루스칼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 원더랜드(최소스패닝트리)
     유형 : 최소 신장 트리(MST), 크루스칼 알고리즘
     시간 복잡도 : O(N)
     난이도 : 보통
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/09-07
     날짜 : 22.11.6
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73417?tab=community
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int v = Integer.parseInt(strings[0]);
        int e = Integer.parseInt(strings[1]);
        PriorityQueue<Node> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new Node(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int[] ints = new int[v + 1];
        boolean[] booleans = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            ints[i] = i;
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (isNotConnected(node.locationA, node.locationB, ints)) {
                union(node.locationA, node.locationB, ints);
                booleans[node.locationB] = true;
                node.locationA = node.locationB;
                answer += node.cost;
            }
        }
        System.out.println(answer);
    }

    private static boolean isNotConnected(int locationA, int locationB, int[] ints) {
        return find(locationA, ints) != find(locationB, ints);
    }

    static int find(int num, int[] ints) {
        if (num == ints[num]) {
            return num;
        }
        return ints[num] = find(ints[num], ints);
    }

    static void union(int a, int b, int[] ints) {
        ints[find(b, ints)] = find(a, ints);
    }

    static class Node implements Comparable<Node> {

        int locationA;
        int locationB;
        int cost;

        public Node(int locationA, int locationB, int cost) {
            this.locationA = locationA;
            this.locationB = locationB;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return o.cost - cost;
        }
    }
}
