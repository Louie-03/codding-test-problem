package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No9095 {

    //    n = n-1 + n-2 + n-3
    public static void no9095(int i, int n, int[] dpArray) {
        if (i <= n) {
            dpArray[i] = dpArray[i - 1] + dpArray[i - 2] + dpArray[i - 3];
            no9095(i + 1, n, dpArray);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            inputs[i] = num;
            if (num > max) {
                max = num;
            }
        }

        int[] dpArray = new int[max + 1];
        dpArray[1] = 1;
        dpArray[2] = 2;
        dpArray[3] = 4;
        no9095(4, max, dpArray);
        Arrays.stream(inputs).forEach(i -> System.out.println(dpArray[i]));
    }
}
