package inflearn.정렬.장난꾸러기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 장난꾸러기
     유형 : 정렬
     시간 복잡도 : O(N Log N)
     난이도 : 매우 쉬움
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/06-06
     날짜 : 22.10.26
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int[] clone = ints.clone();
        Arrays.sort(clone);
        int count = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (ints[i] != clone[i]) {
                if (count == 0) {
                    a = i + 1;
                }
                if (count == 1) {
                    b = i + 1;
                }
                count++;
            }
        }
        System.out.println(a + " " + b);
    }

    private static int findA(int a, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[a - 1] == ints[i]) {
                return i + 1;
            }
        }
        return 0;
    }

    private static int findB(int a, int[] ints) {
        int anInt = ints[a];
        int b = 0;
        for (int i = 0; i < ints.length; i++) {
            if (anInt == ints[i]) {
                b = i + 1;
            }
        }
        return b;
    }
    /*
9
120 125 152 130 135 135 143 127 160
3 8

5
10 20 30 40 30
10 20 30 30 40  4 5

5
10 20 40 30 30
10 20 30 30 40  3 5

10 20 30 40 40
10 20 40 40 30
     */
}
