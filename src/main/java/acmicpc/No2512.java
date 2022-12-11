package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int length = n - 1;
        int[] ints = new int[n];
        int[] sums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            ints[i] = num;
            if (num > max) {
                max = num;
            }
        }
        Arrays.sort(ints);
        sums[0] = ints[0];
        for (int i = 1; i < n; i++) {
            sums[i] = ints[i] + sums[i - 1];
        }
        int m = Integer.parseInt(br.readLine());
        if (sums[length] <= m) {
            System.out.println(max);
        } else {
            int start = 1;
            int end = max - 1;
            int n2 = (int) (Math.log(max) / Math.log(2));
            int num = 0;
            for (int i = 0; i <= n2; i++) {
                int x = (start + end) / 2;
                int index = getIndex(ints, x, length);
                int sum = 0;
                if (index != -1) {
                    sum = sums[index];
                }
                sum = (length - index) * x + sum;
                if (sum > m) {
                    end = x - 1;
                } else {
                    if (num < x) {
                        num = x;
                    }
                }
                if (sum < m) {
                    start = x + 1;
                }
            }
            System.out.println(num);
        }
    }

    private static int getIndex(int[] ints, int x, int length) {
        for (int i = 0; i < length; i++) {
            if (ints[i] >= x) {
                return i - 1;
            }
        }
        return length - 1;
    }
}
