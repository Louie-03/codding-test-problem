package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            ints[i] = num;
            if (max < num) {
                max = num;
            }
        }

        int start = 0;
        int end = max;
        while (start <= end) {
            int x = (start + end) / 2;
            long sum = 0;
            for (int j = 0; j < n; j++) {
                int num = ints[j];
                if (num > x) {
                    sum += num - x;
                }
            }
            if (sum >= m) {
                start = x + 1;
            } else {
                end = x - 1;
            }
        }
        System.out.println(end);
    }
}
