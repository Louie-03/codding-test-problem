package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        int v = Integer.parseInt(strings[2]);

        int day = (v - b) / (a - b);
        if ((v - b) % (a - b) > 0) {
            day++;
        }

        System.out.println(day);
    }
}
