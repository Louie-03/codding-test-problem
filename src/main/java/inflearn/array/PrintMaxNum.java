package inflearn.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PrintMaxNum {

//    1. 큰 수 출력하기 https://cote.inflearn.com/contest/10/problem/02-01
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                bw.write(ints[i] + " ");
                continue;
            }
            if (ints[i] > ints[i - 1]) {
                bw.write(ints[i] + " ");
            }
        }
        bw.flush();
    }
}
