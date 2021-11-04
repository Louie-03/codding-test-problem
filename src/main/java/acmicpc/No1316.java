package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        int count = 0;

        for (String string : strings) {
            boolean[] booleans = new boolean[26];
            boolean check = true;
            int length = string.length();

            for (int j = 0; j < length; j++) {
                char c = string.charAt(j);
                if (j < length - 1 && string.charAt(j + 1) == c) {
                    continue;
                }
                if (booleans[c - 97] == true) {
                    check = false;
                    break;
                }
                booleans[c - 97] = true;
            }

            if (check) count++;
        }

        System.out.println(count);
    }
}