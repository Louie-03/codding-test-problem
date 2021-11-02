package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int num1 = Integer.parseInt(strings[0]);
        int num2 = Integer.parseInt(strings[1]);

        int newNum1 = 0;
        int newNum2 = 0;

        for (int i = 0; i < 3; i++) {
            int n1 = num1 % 10;
            num1 /= 10;

            int n2 = num2 % 10;
            num2 /= 10;

            newNum1 *= 10;
            newNum2 *= 10;

            newNum1 += n1;
            newNum2 += n2;
        }

        System.out.println(Math.max(newNum1, newNum2));
    }
}