package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No1045 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        BigInteger num1 = new BigInteger(strings[0]);
        BigInteger num2 = new BigInteger(strings[1]);
        double d1 = num1.doubleValue();
        double d2 = num2.doubleValue();

        System.out.println(num1.add(num2));
        System.out.println(num1.subtract(num2));
        System.out.println(num1.multiply(num2));
        System.out.println(num1.divide(num2));
        System.out.println(num1.remainder(num2));
        System.out.println(String.format("%.2f", d1 / d2));
    }
}
