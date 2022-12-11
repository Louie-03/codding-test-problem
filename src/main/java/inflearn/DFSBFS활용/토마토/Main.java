package inflearn.DFSBFS활용.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 토마토(BFS 활용)
     유형 : BFS
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://cote.inflearn.com/contest/10/problem/08-12
     날짜 : 22.10.20
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73407
     */

    static int n;
    static int m;
    static int[][] ints;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 1) {
                    queue.add(new Position(j, i));
                }
            }
        }
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = position.x + dx[j];
                    int y = position.y + dy[j];
                    if (0 <= x && x <= n - 1 && 0 <= y && y <= m - 1 && ints[y][x] == 0) {
                        ints[y][x] = 1;
                        queue.add(new Position(x, y));
                    }
                }
            }
//            for (int[] anInt : ints) {
//                for (int i : anInt) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            L++;
        }
        for (int[] anInt : ints) {
            for (int i : anInt) {
                if (i == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(L - 1);
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
