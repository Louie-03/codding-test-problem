package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num16 = br.readLine();
        Integer num10 = Integer.valueOf(num16, 16);
        String num8 = Integer.toOctalString(num10);

        System.out.println(num8);
    }
}
