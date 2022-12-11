package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n1 = Integer.parseInt(br.readLine());
        int[] ints1 = new int[n1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            ints1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints1);
        int n2 = Integer.parseInt(br.readLine());
        int[] ints2 = new int[n2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            ints2[i] = Integer.parseInt(st.nextToken());
        }

        int n = (int) (Math.log(n1) / Math.log(2));
        for (int i = 0; i < n2; i++) {
            int start = 0;
            int end = n1 - 1;
            int x = ints2[i];
            boolean check = true;
            for (int j = 0; j <= n; j++) {
                int index = (start + end) / 2;
                int num = ints1[index];
                if (num == x) {
                    bw.write(1 + "\n");
                    check = false;
                    break;
                }
                if (num < x) {
                    start = index + 1;
                }
                if (num > x) {
                    end = index - 1;
                }
            }
            if (check) {
                bw.write(0 + "\n");
            }
        }
        bw.flush();
    }
}
