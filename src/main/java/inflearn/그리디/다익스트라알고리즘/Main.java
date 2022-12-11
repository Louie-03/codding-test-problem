package inflearn.그리디.다익스트라알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 다익스트라 알고리즘
     유형 : 다익스트라 알고리즘
     시간 복잡도 : O(N log N)
     난이도 : 조금 어려움
     시간 : 50m
     uri :
     날짜 : 22.10.25
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73415?category=questionDetail&tab=community
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.get(Integer.parseInt(st.nextToken()))
                .add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int[] ints = new int[n + 1];
        Arrays.fill(ints, Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        ints[1] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.num + " " + node.distance);
            for (Node node1 : map.get(node.num)) {
                int sum = node.distance + node1.distance;
                if (ints[node1.num] > sum) {
                    ints[node1.num] = sum;
                    queue.add(new Node(node1.num, sum));
                }
            }
        }
        System.out.println();
        for (int i = 2; i <= n; i++) {
            int num = ints[i];
            if (num == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i + " : " + num);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }
}

//6 9
//1 2 12
//1 3 4
//2 1 2
//2 3 5
//2 5 5
//3 4 5
//4 2 2
//4 5 5
//6 4 5
