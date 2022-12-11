package acmicpc.no16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 아기 상어
     유형 : BFS
     시간 복잡도 : O(N^2)
     난이도 : 보통
     시간 : 1h
     uri : https://www.acmicpc.net/problem/16236
     날짜 : 22.11.8
     refer :
     */
    static int[][] ints;
    static int n;
    static int sharkSize = 2;
    static int eatenCount;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ints = new int[n][n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    x = j;
                    y = i;
                } else {
                    ints[i][j] = num;
                }
            }
        }

        int answer = 0;
        while (true) {
            Fish fish = bfs(x, y);
            if (fish.distance == -1) {
                break;
            }
            answer += fish.distance;
            eatenCount++;
            if (sharkSize == eatenCount) {
                sharkSize++;
                eatenCount = 0;
            }
            x = fish.x;
            y = fish.y;
            ints[y][x] = 0;
        }
        System.out.println(answer);
    }

    private static Fish bfs(int x, int y) {
        int distance = 0;
        List<Fish> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        boolean canEat = false;
        boolean[][] check = new boolean[n][n];
        check[y][x] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                int i1 = ints[position[1]][position[0]];
                if (i1 != 0 && i1 != 9 && i1 < sharkSize) {
                    list.add(new Fish(position[0], position[1], distance));
                    canEat = true;
                }
                for (int j = 0; j < 4; j++) {
                    int nowX = position[0] + dx[j];
                    int nowY = position[1] + dy[j];
                    if ((0 <= nowX && nowX < n && 0 <= nowY && nowY < n) && !check[nowY][nowX] &&
                    (ints[nowY][nowX] == 0 || ints[nowY][nowX] <= sharkSize)) {
                        check[nowY][nowX] = true;
                        queue.add(new int[]{nowX, nowY});
                    }
                }
            }
            if (canEat) {
                break;
            }
            distance++;
        }
        if (canEat) {
            Collections.sort(list);
            return list.get(0);
        }
        return new Fish(-1, -1, -1);
    }

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish o) {
            if (y == o.y) {
                return x - o.x;
            }
            return y - o.y;
        }
    }
    /*
    먹을 수 있는 물고기 중 가장 가까운 물고기를 우선으로 먹음
        자기보다 작은 물고기만 먹을 수 있음
        거리가 같다면 가장 위에 있는 물고기를 먹는다
            높이까지 같다면 가장 왼쪽에 있는 물고기를 먹는다.
    이동한 칸 수를 구해야함
        자기보다 큰 물고기가 있는 곳은 지나가지 못함

    3   2   1   3, 0
    4   3   0   2, 0
    5   3   1   1, 0
    6   3   2   0, 0

    3, 0    3
    0, 3    6
    1, 3    1
    2, 0    4
     */
}
