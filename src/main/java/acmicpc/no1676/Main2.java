package acmicpc.no1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }
        String string = bigInteger.toString();
        int count = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) != '0') {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
