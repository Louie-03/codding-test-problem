package acmicpc.no7576;

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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ints[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }
        int count = 0;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        while (!queue.isEmpty()) {
            int size = queue.size() / 2;
            count++;
            for (int i = 0; i < size; i++) {
                Integer a = queue.poll();
                Integer b = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int x = a + dx[j];
                    int y = b + dy[j];
                    if (x >= 0 && x < n && y >= 0 && y < m && ints[x][y] == 0) {
                        queue.add(x);
                        queue.add(y);
                        ints[x][y] = 1;
                    }
                }

            }
        }

        for (int[] anInt : ints) {
            for (int i : anInt) {
                if (i == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count - 1);
    }

}
