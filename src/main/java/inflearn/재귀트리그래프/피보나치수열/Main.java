package inflearn.재귀트리그래프.피보나치수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] ints;
    /*
     문제 : 피보나치 수열
     유형 : 재귀
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri :
     날짜 : 22.10.13
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        recursive(1, 0, n);
        ints = new int[n];
        ints[0] = 1;
        ints[1] = 1;
        recursive2(n);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void recursive(int a, int b, int n) {
        if (n != 0) {
            System.out.print((a + b) + " ");
            recursive(b, a + b, n - 1);
        }
    }

    private static int recursive2(int n) {
        if (n == 1 || n == 2) {
            return ints[n - 1];
        }
        if (ints[n - 1] != 0) {
            return ints[n - 1];
        }
        ints[n - 1] = recursive2(n - 1) + recursive2(n - 2);
        return ints[n - 1];
    }
}
