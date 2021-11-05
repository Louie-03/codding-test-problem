package acmicpc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count;
        if (n < 100) {
            count = n % 100;
        } else {
            count = 99;
        }

        int[] ints;
        for (int i = 100; i <= n; i++) {
            if (i == 1000) {
                break;
            }

            ints = new int[3];
            int num = i;
            for (int j = 2; j >= 0; j--) {
                ints[j] = num % 10;
                num /= 10;
            }

            int difference = ints[0] - ints[1];
            if (difference == ints[1] - ints[2]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
