package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int anInt = ints[i];
            for (int j = i + 1; j < n; j++) {
                int anInt1 = ints[j];
                if (anInt > anInt1) {
                    sum++;
                    anInt = anInt1;
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
