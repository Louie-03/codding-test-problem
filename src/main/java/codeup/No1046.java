package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No1046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        BigInteger num1 = new BigInteger(strings[0]);
        BigInteger num2 = new BigInteger(strings[1]);
        BigInteger num3 = new BigInteger(strings[2]);

        BigInteger sum = num1.add(num2.add(num3));
        System.out.println(sum);
        System.out.printf("%.1f", sum.doubleValue() / 3);
    }
}
