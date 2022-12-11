package inflearn.DFSBFS활용.미로의최단거리통로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 미로의 최단거리 통로(BFS)
     유형 : BFS
     시간 복잡도 : O(3^N)
     난이도 : 조금 어려움
     시간 : 50m
     uri : https://cote.inflearn.com/contest/10/problem/08-11
     날짜 : 22.10.19
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73406?category=questionDetail&tab=curriculum
     */
    static final Position DESTINATION = new Position(6, 6, null);
    static final int[][] ints = new int[7][7];
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                int num = Integer.parseInt(st.nextToken());
                ints[i][j] = num;
                if (num == 0) {
                    maxCount++;
                }
            }
        }
//        bfs();
        bfs2();
    }

    private static void bfs2() {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
//        for (int i = 0; i < 7; i++) {
//            Arrays.fill(ints[i], Integer.MAX_VALUE);
//        }
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
//            System.out.println(L + "=======================");
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                if (position.equals(DESTINATION)) {
                    System.out.println(L);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int x = position.x + dx[j];
                    int y = position.y + dy[j];
                    Position newPosition = new Position(x, y);
                    if (0 <= x && x <= 6 && 0 <= y && y <= 6 && ints[x][y] != 1 && (ints[x][y] == 0 || ints[x][y] > ints[position.x][position.y] + 1)) {
                        ints[x][y] = ints[position.x][position.y] + 1;
//                        System.out.println(newPosition + " " + ints[x][y]);
                        queue.add(newPosition);
                    }
                }
            }
            L++;
        }
        System.out.println(-1);
    }

    private static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, null));
        int L = 0;
        while (!queue.isEmpty()) {
            if (maxCount == L) {
                System.out.println(-1);
                return;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                if (position.equals(DESTINATION)) {
//                    while (position != null) {
//                        System.out.println(position);
//                        position = position.beforePosition;
//                    }
                    System.out.println(L);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int x = position.x + dx[j];
                    int y = position.y + dy[j];
                    Position newPosition = new Position(x, y, position);
                    if (0 <= x && x <= 6 && 0 <= y && y <= 6 && ints[x][y] == 0 && !newPosition.equals(position.beforePosition)) {
                        queue.add(newPosition);
                    }
                }
            }
            L++;
        }
        System.out.println(-1);
    }

    static class Position {
        int x;
        int y;
        Position beforePosition;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position(int x, int y, Position beforePosition) {
            this.x = x;
            this.y = y;
            this.beforePosition = beforePosition;
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

    /*
    내 풀이가 틀린 이유
    1. 벽까지 탐색시킴
    2. 시간복잡도 너무 높음

    문제의 풀이가 안된다고 생각했던 이유
    이미 접근한거랑 벽이랑 구분을 못해서 구현하기 어려울 것 같다고 생각했는데
    다시 생각해보니까 앞에서 먼저 탐색해서 1이 되면 오히려 먼저 탐색한거니까 이후에 탐색한 것보다는 레벨이 높을 수가 없음
    결국 탐색 1이면 안해도 됨

     */
}
