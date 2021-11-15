package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; ; i++) {
            sum += i;
            if (sum >= num) {
                break;
            }
        }

        System.out.println(sum);
    }
}
