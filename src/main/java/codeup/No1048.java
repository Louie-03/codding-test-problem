package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No1048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);

        int pow = (int) Math.pow(2, b);
        System.out.println(a * pow);
        System.out.println(3 & 5);
    }
}
