package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No9095 {
    public static int no9095(int n) {
        int[] dpArray = new int[n + 3];
        dpArray[1] = 1;
        dpArray[2] = 2;
        dpArray[3] = 4;
        for (int i = 4; i <= n; i++) {
            dpArray[i] = dpArray[i - 1] + dpArray[i - 2] + dpArray[i - 3];
        }
        return dpArray[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.stream(inputs).forEach(i -> System.out.println(no9095(i)));
    }
}