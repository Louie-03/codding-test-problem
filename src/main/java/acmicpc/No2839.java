package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min = n;
        for (int i = 0; i <= n / 5; i++) {
            int kg = n - 5 * i;
            int count = i;
            for (int j = 0; j <= kg / 3; j++) {
                kg -= j * 3;
                count += j;

                if (kg == 0 && count < min) {
                    min = count;
                }
                kg = n - 5 * i;
                count = i;
            }
        }

        if (min == n) {
            min = -1;
        }
        System.out.println(min);
    }
}
