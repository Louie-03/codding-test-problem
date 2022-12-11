package acmicpc.no7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 토마토
     유형 : BFS
     시간 복잡도 : O(NlogN)
     난이도 : 쉬움
     시간 : 25m
     uri : https://www.acmicpc.net/problem/7569
     날짜 : 22.11.7
     refer :
     */
    static int m;
    static int n;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][][] ints = new int[h][n][m];
        int zeroCount = 0;
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    ints[i][j][k] = num;
                    if (num == 0) {
                        zeroCount++;
                    }
                    if (num == 1) {
                        queue.add(new Position(k, j, i));
                    }
                }
            }
        }
        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }
        List<Position> positions = List.of(
            new Position(1, 0, 0),
            new Position(-1, 0, 0),
            new Position(0, 1, 0),
            new Position(0, -1, 0),
            new Position(0, 0, 1),
            new Position(0, 0, -1)
        );
        int answer = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                for (Position position1 : positions) {
                    int x = position.x + position1.x;
                    int y = position.y + position1.y;
                    int z = position.z + position1.z;
                    if (isNotOutOfBounds(x, y, z) && ints[z][y][x] == 0) {
                        zeroCount--;
                        ints[z][y][x] = 1;
                        queue.add(new Position(x, y, z));
                    }
                }
            }
            answer++;
        }

        if (zeroCount == 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isNotOutOfBounds(int x, int y, int z) {
        return 0 <= x && x < m && 0 <= y && y < n && 0 <= z && z < h;
    }

    static class Position {
        int x;
        int y;
        int z;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return z + " " + y + " " + x;
        }
    }
}
