package acmicpc.no16973;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int fr = Integer.parseInt(st.nextToken());
        int fc = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[n][m];
        boolean[][] canMove = new boolean[n][m];
        for (int i = 0; i <= n - h; i++) {
            for (int j = 0; j <= m - w; j++) {
                canMove[i][j] = isCanMove(ints, h, w, i, j);
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sr - 1);
        queue.add(sc - 1);
        check[sr - 1][sc - 1] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size() / 2;
                for (int i = 0; i < size; i++) {

                Integer a = queue.poll();
                Integer b = queue.poll();

                if (a == fr - 1 && b == fc - 1) {
                    System.out.println(count);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int x = a + dx[j];
                    int y = b + dy[j];

                    if (x >= 0 && x < n && y >= 0 && y < m && !check[x][y] &&
                        !(n - x < h || m - y < w) && canMove[x][y]) {
                        queue.add(x);
                        queue.add(y);
                        check[x][y] = true;
                    }
                }
            }

            count++;

        }

        System.out.println(-1);
    }

    static boolean isCanMove(int[][] ints, int h, int w, int i, int j) {
        for (int k = i; k < i + h; k++) {
            for (int l = j; l < j + w; l++) {
                if (ints[k][l] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
