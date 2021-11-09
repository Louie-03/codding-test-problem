package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int[] kArray = new int[a];
        int[] nArray = new int[a];
        for (int i = 0; i < a; i++) {
            kArray[i] = Integer.parseInt(br.readLine());
            nArray[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < a; i++) {
            int k = kArray[i];
            int n = nArray[i];

            int[] ints = new int[n];
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    for (int l = 1; l <= n; l++) {
                        ints[l - 1] = l;
                    }
                    continue;
                }

                int[] intsA = new int[n];
                for (int l = 0; l < n; l++) {
                    int sum = 0;
                    for (int m = 0; m <= l; m++) {
                        sum += ints[m];
                    }
                    intsA[l] = sum;
                }
                ints = Arrays.copyOf(intsA, intsA.length);
            }

            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += ints[j];
            }
            System.out.println(sum);
        }
    }
}
