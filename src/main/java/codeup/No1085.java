package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        double result = 1;
        for (String string : strings) {
            result *= Integer.parseInt(string);
        }

        System.out.printf("%.1f MB", result / 8 / Math.pow(2, 10) / Math.pow(2, 10));
    }
}
