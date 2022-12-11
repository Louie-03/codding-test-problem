package acmicpc.no11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : ATM
     유형 : 정렬, 그리디 알고리즘
     시간 복잡도 : O(NlogN)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://www.acmicpc.net/problem/11399
     날짜 : 22.11.7
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints);
        int answer = ints[0];
        for (int i = 1; i < n; i++) {
            ints[i] += ints[i - 1];
            answer += ints[i];
        }
        System.out.println(answer);
    }
    /*
    1 2 3 3 4
    1 3 6 9 13
     */
}
