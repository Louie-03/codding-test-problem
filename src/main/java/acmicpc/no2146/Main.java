package acmicpc.no2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 다리 만들기
     유형 : BFS
     시간 복잡도 : O(N)
     난이도 : 조금 쉬움
     시간 : 40m
     uri : https://www.acmicpc.net/problem/2146
     날짜 : 22.12.17
     refer :
     */
    static int sequence = 2;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 1) {
                    dfs(i, j, ints);
                }
            }
        }
        boolean[][][] visited = new boolean[sequence + 1][n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] != 0) {
                    queue.add(new int[]{j, i, ints[i][j]});
                    visited[ints[i][j]][i][j] = true;
                }
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int x = poll[0] + dx[j];
                    int y = poll[1] + dy[j];
                    if (!(0 <= x && x < ints.length && 0 <= y && y < ints.length)) {
                        continue;
                    }
                    if (ints[y][x] != 0 && ints[y][x] != poll[2]) {
                        System.out.println(count);
                        return;
                    }
                    if (!visited[poll[2]][y][x]) {
                        queue.add(new int[]{x, y, poll[2]});
                        visited[poll[2]][y][x] = true;
                    }
                }
            }
            count++;
        }
    }

    private static void dfs(int startY, int startX, int[][] ints) {
        ints[startY][startX] = sequence;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        while (!queue.isEmpty()) {
            int[] ints1 = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int x = ints1[0] + dx[i];
                int y = ints1[1] + dy[i];
                if (0 <= x && x < ints[0].length && 0 <= y && y < ints.length
                    && ints[y][x] == 1) {
                    ints[y][x] = sequence;
                    queue.add(new int[]{x, y});
                }
            }
        }
        sequence++;
    }
    /*
    그냥 싹다 처음에 큐에다가 넣고 bfs 돌리면 시간 초과가 발생할려나?

    3차원 배열을 통해 방문했는지 확인하여 최적화 or 섬의 가장자리만 큐에 추가하여 시간복잡도 최적화
     */
}
