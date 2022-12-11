package acmicpc.no14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : N-Queen
     유형 : BFS, DFS
     시간 복잡도 : O(N^8)
     난이도 : 매우 어려움
     시간 : 1h
     uri : https://www.acmicpc.net/problem/14502
     날짜 : 22.11.10
     refer : https://dding9code.tistory.com/3
     */
    static int n;
    static int m;
    static int[][] map;
    static int answer;
    static Node[] nodes = {
        new Node(1, 0),
        new Node(0, 1),
        new Node(-1, 0),
        new Node(0, -1)
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0);
        System.out.println(answer);
    }

    static void recursive(int count) { //N^6
        if (count == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    recursive(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() { //N^2
        int[][] cloneMap = cloneMap();
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cloneMap[i][j] == 2) {
                    queue.add(new Node(j, i));
                }
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node node1 : nodes) {
                int x = node.x + node1.x;
                int y = node.y + node1.y;
                if (0 <= x && x < m && 0 <= y && y < n && cloneMap[y][x] == 0) {
                    cloneMap[y][x] = 2;
                    queue.add(new Node(x, y));
                }
            }
        }
        int count = 0;
        for (int[] ints1 : cloneMap) {
            for (int i : ints1) {
                if (i == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }

    static int[][] cloneMap() {
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) {
            array[i] = map[i].clone();
        }
        return array;
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
