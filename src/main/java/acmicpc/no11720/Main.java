package acmicpc.no11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String strings = br.readLine();

        System.out.println(solution(n, strings));
    }

    static int solution(int n, String strings) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = strings.charAt(i) - 48;
            sum += num;
        }
        return sum;
    }

}
