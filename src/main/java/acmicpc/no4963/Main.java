package acmicpc.no4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 섬의 개수
     유형 : BFS
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/4963
     날짜 : 22.12.17
     refer :
     */
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            boolean[][] booleans = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    booleans[i][j] = st.nextToken().equals("1");
                }
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (booleans[i][j]) {
                        bfs(i, j, booleans);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int startY, int startX, boolean[][] booleans) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int x = ints[1] + dx[i];
                int y = ints[0] + dy[i];
                if (0 <= x && x < booleans[0].length && 0 <= y && y < booleans.length
                    && booleans[y][x]) {
                    booleans[y][x] = false;
                    queue.add(new int[]{y, x});
                }
            }
        }
    }
}
