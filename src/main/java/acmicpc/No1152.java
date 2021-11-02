package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] strings = s.split(" ");
        int length = strings.length;

        if (s.charAt(0) == ' ' && s.trim().length() != 0) {
            length--;
        }

        System.out.println(length);
    }
}