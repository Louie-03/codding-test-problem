package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] ints = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int num = (int) s.charAt(i);
            if (num >= 97) {
                num -= 32;
            }
            ints[num - 65] += 1;
        }

        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }

        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == max) {
                count++;
            }
        }

        if (count == 1) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == max) {
                    System.out.println((char) (i + 65));
                }
            }
        } else {
            System.out.println('?');
        }
    }
}