package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        double result = 1;
        for (String string : strings) {
            result *= Double.parseDouble(string);
        }
        result /= 8 * 1024 * 1024;

        System.out.printf("%.2f MB", result);
    }
}
