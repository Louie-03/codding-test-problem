package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] ints = new int[26];
        Arrays.fill(ints, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (ints[index] == -1) {
                ints[index] = i;
            }
        }

        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}