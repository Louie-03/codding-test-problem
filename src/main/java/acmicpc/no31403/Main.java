package acmicpc.no31403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        System.out.println(a + b - c);

        int answer = a;
        int length = (b + "").length();
        for (int i = 0; i < length; i++) {
            answer *= 10;
        }
        System.out.println(answer + b - c);
    }

}
