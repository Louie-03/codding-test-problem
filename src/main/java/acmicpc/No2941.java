package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
        String input = br.readLine();

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (input.contains(string)) {
                input = input.replace(string, "*");
            }
        }

        System.out.println(input.length());
    }
}