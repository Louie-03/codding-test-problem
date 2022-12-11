package inflearn.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GridMaxSum {

//    9. 격자판 최대합 https://cote.inflearn.com/contest/10/problem/02-09
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += ints[i][i];
            sum2 += ints[i][n - 1 - i];

            int sum3 = 0;
            int sum4 = 0;
            for (int j = 0; j < n; j++) {
                sum3 += ints[i][j];
                sum4 += ints[j][i];
            }
            int sum = Math.max(sum3, sum4);
            maxSum = Math.max(maxSum, sum);
        }

        maxSum = Math.max(maxSum, Math.max(sum1, sum2));
        System.out.println(maxSum);
    }
}
