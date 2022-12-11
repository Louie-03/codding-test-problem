package acmicpc.no2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 미로탐색
     유형 : BFS
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 10m
     uri : https://www.acmicpc.net/problem/2178
     날짜 : 22.11.7
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] booleans = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                booleans[i][j] = (string.charAt(j) == '1');
            }
        }
        System.out.println(bfs(n, m, booleans));
    }

    private static int bfs(int n, int m, boolean[][] booleans) {
        boolean[][] visits = new boolean[n][m];
        List<Position> positions = List.of(
            new Position(1, 0),
            new Position(-1, 0),
            new Position(0, 1),
            new Position(0, -1)
        );
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        visits[0][0] = true;
        int answer = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                if (position.x == m - 1 && position.y == n - 1) {
                    return answer;
                }
                for (Position position1 : positions) {
                    int x = position.x + position1.x;
                    int y = position.y + position1.y;
                    if (0 <= x && x < m && 0 <= y && y < n && booleans[y][x] && !visits[y][x]) {
                        visits[y][x] = true;
                        queue.add(new Position(x, y));
                    }
                }
            }
            answer++;
        }
        throw new IllegalStateException("도착지를 찾을 수 없습니다.");
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
