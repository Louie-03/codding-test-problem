package programmers.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public int solution(int[][] maps) {
        boolean[][] check = new boolean[maps.length][maps[0].length];
        int answer = 1;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                if (position.y == maps.length - 1 && position.x == maps[0].length - 1) {
                    return answer;
                }
                for (int j = 0; j < 4; j++) {
                    int x = position.x + dx[j];
                    int y = position.y + dy[j];
                    if (0 <= x && x < maps[0].length && 0 <= y && y < maps.length
                        && !check[y][x] && maps[y][x] == 1) {
                        check[y][x] = true;
                        queue.add(new Position(x, y));
                    }
                }
            }
            answer++;
        }
        return -1;
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
