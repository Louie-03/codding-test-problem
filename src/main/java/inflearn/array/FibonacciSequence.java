package inflearn.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FibonacciSequence {

    //    4. 피보나치 수열 https://cote.inflearn.com/contest/10/problem/02-04
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        ints[0] = 1;
        ints[1] = 1;

        for (int i = 2; i < n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }

        for (int anInt : ints) {
            bw.write(anInt + " ");
        }
        bw.flush();
    }
}
