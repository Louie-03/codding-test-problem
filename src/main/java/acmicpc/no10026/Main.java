package acmicpc.no10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    /*
     문제 : 적록색약
     유형 : BFS
     시간 복잡도 : O(N^2)
     난이도 : 쉬움
     시간 : 1h 5m
     uri : https://www.acmicpc.net/problem/10026
     날짜 : 22.11.7
     refer :
     */
    static List<Position> positions = List.of(
        new Position(1, 0),
        new Position(-1, 0),
        new Position(0, 1),
        new Position(0, -1)
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Character[][] chars1 = new Character[n][n];
        Character[][] chars2 = new Character[n][n];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = string.charAt(j);
                chars1[i][j] = c;
                chars2[i][j] = c;
            }
        }
        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chars1[i][j] != null) {
                    Position position = new Position(j, i, chars1[i][j]);
                    dfs(chars1, position, false);
                    answer1++;
                }
                if (chars2[i][j] != null) {
                    Position position = new Position(j, i, chars2[i][j]);
                    dfs(chars2, position, true);
                    answer2++;
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
    }

    private static void dfs(Character[][] chars, Position position, boolean colorBlindness) {
        chars[position.y][position.x] = null;
        for (Position position1 : positions) {
            int x = position.x + position1.x;
            int y = position.y + position1.y;
            if (0 <= x && x < chars.length && 0 <= y && y < chars.length) {
                Position position2 = new Position(x, y, chars[y][x]);
                if (position2.colorIsNotNull() && position.isEqualsColor(position2, colorBlindness)) {
                    dfs(chars, position2, colorBlindness);
                }
            }
        }
    }

    static class Position {
        int x;
        int y;
        Character color;

        public Position(int x, int y, Character color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isEqualsColor(Position position, boolean colorBlindness) {
            if (colorBlindness) {
                return (color == 'B') == (position.color == 'B');
            }
            return color == position.color;
        }

        public boolean colorIsNotNull() {
            return color != null;
        }
    }
}
