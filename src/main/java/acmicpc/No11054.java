package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int[] increaseDp = new int[n];
        int[] decreaseDp = new int[n];
        Arrays.fill(increaseDp, 1);
        Arrays.fill(decreaseDp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[i] > ints[j] && increaseDp[i] <= increaseDp[j]) {
                    increaseDp[i] = increaseDp[j] + 1;
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (ints[i] > ints[j] && decreaseDp[i] <= decreaseDp[j]) {
                    decreaseDp[i] = decreaseDp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = increaseDp[i] + decreaseDp[i];
            if (max < sum) {
                max = sum;
            }
        }
        System.out.println(max - 1);
    }
}
