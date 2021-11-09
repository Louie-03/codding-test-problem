package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int increment = 0;  // 0 6 12 18 24 30
        int max = 1;        // 1 7 19 37 61 91
        int count = 1;      // 1 2 3  4  5  6

        for (int i = 0; i > -1; i++) {
            if (max >= n) {
                break;
            }
            count++;
            increment += 6;
            max += increment;
        }

        System.out.println(count);
    }
}
