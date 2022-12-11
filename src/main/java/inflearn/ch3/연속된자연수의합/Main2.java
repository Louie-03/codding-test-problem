package inflearn.ch3.연속된자연수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 2; i <= n / 2 + 1; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
            if ((n - sum) % i == 0 && sum <= n) {
                count++;
            }
        }
        System.out.println(count);
    }
}
