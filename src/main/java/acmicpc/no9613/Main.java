package acmicpc.no9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : GCD 합
     유형 : 유클리드 호재법, 수학
     시간 복잡도 : ?
     난이도 : 조금 쉬움
     시간 : 30m
     uri : https://www.acmicpc.net/problem/9613
     날짜 : 22.12.12
     refer :
     */
    public static void main(String[] args) throws IOException {
        int[][] ints = getArray();
        StringBuilder sb = new StringBuilder();
        for (int[] anInt : ints) {
            sb.append(getGcdSum(anInt)).append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] getArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            ints[i] = new int[size];
            for (int j = 0; j < size; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return ints;
    }

    static long getGcdSum(int[] anInt) {
        if (anInt.length == 1) {
            return anInt[0];
        }

        long gcdSum = 0;
        for (int i = 0; i < anInt.length; i++) {
            for (int j = i + 1; j < anInt.length; j++) {
                gcdSum += gcd(anInt[i], anInt[j]);
            }
        }
        return gcdSum;
    }

    private static int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (max % min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        return min;
    }
    /*
    3
    4 10 20 30 40
    3 7 5 12
    3 125 15 25

    10 20   10
    10 30   10
    10 40   10
    20 30   10
    20 40   20
    30 40   10
            70

    7 5     1
    5 12    1
    7 12    1
            3

    125 15  5
    125 25  25
    15 25   5
            35


     */
}
