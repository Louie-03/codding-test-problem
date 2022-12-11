package inflearn.DFSBFS활용.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 미로탐색(DFS)
     유형 : DFS
     시간 복잡도 : ?
     난이도 : 보통
     시간 : 50m
     uri : https://cote.inflearn.com/contest/10/problem/08-10
     날짜 : 22.10.19
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73405?category=questionDetail&tab=curriculum
     */
    static final int[][] ints = new int[7][7];
    static final boolean[][] booleans = new boolean[7][7];
    static final Stack<Position> stack = new Stack<>();
    static final Position DESTINATION = new Position(6, 6);
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        stack.push(new Position(0, 0));
        booleans[0][0] = true;
        dfs();
        System.out.println(count);
    }

    private static void dfs() {
        Position position = stack.peek();
        if (position.equals(DESTINATION)) {
            count++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = position.x + dx[i];
            int y = position.y + dy[i];
            if (0 <= x && x <= 6 && 0 <= y && y <= 6 && ints[y][x] == 0 && !booleans[x][y]) {
                booleans[x][y] = true;
                stack.push(new Position(x, y));
                dfs();
                booleans[x][y] = false;
                stack.pop();
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}
