package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TemporaryClassMonitor {

//    11. 임시반장 정하기 https://cote.inflearn.com/contest/10/problem/02-11
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][n];
        boolean[][] booleans = new boolean[n][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k && ints[j][i] == ints[k][i]) {
                        booleans[k][j] = booleans[j][k] = true;
                    }
                }
            }
        }

        int maxCount = 0;
        int maxNum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (boolean b : booleans[i]) {
                if (b) {
                    count++;
                }
            }
            if (count >= maxCount) {
                maxCount = count;
                maxNum = i;
            }
        }
        System.out.println(maxNum + 1);
    }
}
