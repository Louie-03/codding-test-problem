package inflearn.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GetRank {

//    8. 등수구하기 https://cote.inflearn.com/contest/10/problem/02-08
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
            int num = ints[i];
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (num < ints[j]) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }
        bw.flush();
    }
}
