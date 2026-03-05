package acmicpc.no2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);

        System.out.println(solution(n, k));
    }

    static int solution(int n, int k) {
        int i = 1;
        int aliquotCount = 0;

        while (i <= n) {
            if (n % i == 0) {
                aliquotCount++;
                if (aliquotCount == k) {
                    return i;
                }
            }

            i++;
        }

        return 0;
    }

}
