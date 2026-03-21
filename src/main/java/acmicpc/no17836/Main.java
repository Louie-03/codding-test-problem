package acmicpc.no17836;

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
        int t = Integer.parseInt(st.nextToken());
        int[][] ints = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] check = new boolean[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(0);
        check[0][0] = true;
        int count = 0;
        boolean answerCheck = false;
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            count++;
            if (count > t) {
                break;
            }

            int size = queue.size();
            for (int i = 0; i < size / 2; i++) {
                Integer a = queue.poll();
                Integer b = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = a + dx[j];
                    int y = b + dy[j];

                    if (x == n - 1 && y == m - 1) {
                        answerCheck = true;
                        answer = Math.min(answer, count);
                    }
                    if (x >= 0 && x < n && y >= 0 && y < m && !check[x][y] && ints[x][y] != 1) {
                        check[x][y] = true;
                        queue.add(x);
                        queue.add(y);
                    }
                }
            }
        }

        queue = new LinkedList<>();
        boolean gram = false;
        check = new boolean[n][m];
        queue.add(0);
        queue.add(0);
        check[0][0] = true;
        count = 0;
        while (!queue.isEmpty()) {
            count++;
            if (count > t) {
                break;
            }

            int size = queue.size();
            for (int i = 0; i < size / 2; i++) {
                Integer a = queue.poll();
                Integer b = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = a + dx[j];
                    int y = b + dy[j];

                    if (x == n - 1 && y == m - 1) {
                        answerCheck = true;
                        answer = Math.min(answer, count);
                    }
                    if (x >= 0 && x < n && y >= 0 && y < m && ints[x][y] == 2 && check[x][y]) {
                        queue.add(x);
                        queue.add(y);
                    }
                    if (x >= 0 && x < n && y >= 0 && y < m && !check[x][y] &&
                        ((ints[x][y] == 1 && gram) || ints[x][y] != 1)) {
                        if (ints[x][y] == 2) {
                            gram = true;
                            queue = new LinkedList<>();
                            check = new boolean[n][m];
                            size = 0;
                        }
                        check[x][y] = true;
                        queue.add(x);
                        queue.add(y);
                        if (ints[x][y] == 2) {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answerCheck ? answer : "Fail");

//        for (int[] anInt : ints) {
//            for (int i : anInt) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }

}
