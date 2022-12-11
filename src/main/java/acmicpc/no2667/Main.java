package acmicpc.no2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    /*
     문제 : 단지번호붙이기
     유형 : DFS
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 35m
     uri : https://www.acmicpc.net/problem/2667
     날짜 : 22.11.4
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                ints[i][j] = chars[j] - 48;
            }
        }
        List<Node> nodes = List.of(
            new Node(0, 1),
            new Node(1, 0),
            new Node(0, -1),
            new Node(-1, 0)
        );
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 1) {
                    count++;
                    int nodeCount = 1;
                    Stack<Node> stack = new Stack<>();
                    stack.add(new Node(j, i));
                    ints[i][j] = 0;
                    while (!stack.isEmpty()) {
                        Node node = stack.pop();
                        for (Node node1 : nodes) {
                            int x = node.x + node1.x;
                            int y = node.y + node1.y;
                            if (0 <= x && x < n && 0 <= y && y < n && ints[y][x] == 1) {
                                stack.add(new Node(x, y));
                                ints[y][x] = 0;
                                nodeCount++;
                            }
                        }
                    }
                    list.add(nodeCount);
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
