package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 1;

        int length = input.length();
        for (int i = 0; i < length - 1; i++) {
            String s = input.substring(i, i + 2);

            switch (s) {
                case "c=" : case "c-" : case "d-" : case "lj" : case "nj" : case "s=" : case "z=" :
                    i++;

                    if (i == length - 1) {
                        count--;
                    }
                    break;

                case "dz" :
                    if (i < length - 2 && input.charAt(i + 2) == '=') {
                        i += 2;
                    }
            }

            count++;
        }

        System.out.println(count);
    }
}