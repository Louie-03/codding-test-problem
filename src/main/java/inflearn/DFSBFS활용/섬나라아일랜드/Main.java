package inflearn.DFSBFS활용.섬나라아일랜드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 섬나라 아일랜드
     유형 : BFS, DFS
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://cote.inflearn.com/contest/10/problem/08-13
     날짜 : 22.10.20
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73407
     */
    static int n;
    static int[][] ints;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(bfs());
        System.out.println(solution());
    }

    private static int bfs() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 1) {
                    count++;
                    ints[i][j] = 0;
                    Queue<Position> queue = new LinkedList<>();
                    queue.add(new Position(j, i));
                    while (!queue.isEmpty()) {
                        Position position = queue.poll();
                        for (int k = 0; k < dx.length; k++) {
                            int x = position.x + dx[k];
                            int y = position.y + dy[k];
                            if (0 <= x && x <= n - 1 && 0 <= y && y <= n - 1 && ints[y][x] == 1) {
                                ints[y][x] = 0;
                                queue.add(new Position(x, y));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int solution() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 1) {
                    ints[i][j] = 0;
                    count++;
                    dfs(j, i);
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if (0 <= ax && ax <= n - 1 && 0 <= ay && ay <= n - 1 && ints[ay][ax] == 1) {
                ints[ay][ax] = 0;
                dfs(ax, ay);
            }
        }
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
