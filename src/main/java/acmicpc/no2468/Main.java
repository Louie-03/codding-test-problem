package acmicpc.no2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                ints[i][j] = num;
                if (max < num) {
                    max = num;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= max; i++) {
            boolean[][] check = new boolean[n][n];

            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (ints[j][k] >= i && !check[j][k]) {
                        count++;
                        Queue<Integer> queue = new LinkedList<>();
                        queue.add(j);
                        queue.add(k);
                        check[j][k] = true;
                        while (!queue.isEmpty()) {
                            Integer a = queue.poll();
                            Integer b = queue.poll();

                            if (a > 0 && ints[a - 1][b] >= i && !check[a - 1][b]) {
                                check[a - 1][b] = true;
                                queue.add(a - 1);
                                queue.add(b);
                            }
                            if (b < n - 1 && ints[a][b + 1] >= i && !check[a][b + 1]) {
                                check[a][b + 1] = true;
                                queue.add(a);
                                queue.add(b + 1);
                            }
                            if (a < n - 1 && ints[a + 1][b] >= i && !check[a + 1][b]) {
                                check[a + 1][b] = true;
                                queue.add(a + 1);
                                queue.add(b);
                            }
                            if (b > 0 && ints[a][b - 1] >= i && !check[a][b - 1]) {
                                check[a][b - 1] = true;
                                queue.add(a);
                                queue.add(b - 1);
                            }
                        }
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);

    }

//    잠기는 높이가 1부터 입력값 중 최대값일때까지 반복문 돌려야됨

}
