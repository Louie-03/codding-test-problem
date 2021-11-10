package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int sum = 0;
        int i;
        for (i = 1; sum < num; i++) {
            sum += i;
        }

        System.out.println(--i);
    }
}
