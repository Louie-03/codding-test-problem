package inflearn.array.멘토링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//    12. 멘토링 https://cote.inflearn.com/contest/10/problem/02-12
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        int[][] ints = new int[b][a];
        for (int i = 0; i < b; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                int num = Integer.parseInt(st.nextToken()) - 1;
                ints[i][num] = j;
            }
        }

        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j) {
                    continue;
                }
                boolean check = true;
                for (int k = 0; k < b; k++) {
                    if (ints[k][i] < ints[k][j]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
