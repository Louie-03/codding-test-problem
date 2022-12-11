package inflearn.정렬.삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 삽입 정렬
     유형 : 정렬(삽입 정렬)
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://cote.inflearn.com/contest/10/problem/06-03
     날짜 : 22.10.21
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72756?tab=curriculum
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int anInt = ints[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (ints[j] < anInt) {
                    break;
                }
                ints[j + 1] = ints[j];
            }
            ints[j + 1] = anInt;
        }

        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
