package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine(), 16);

        for (int i = 1; i <= 15; i++) {
            System.out.println(Integer.toHexString(num).toUpperCase() + "*" +
                    Integer.toHexString(i).toUpperCase() + "=" +
                    Integer.toHexString(num * i).toUpperCase());
        }
    }
}
