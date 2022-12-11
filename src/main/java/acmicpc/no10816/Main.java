package acmicpc.no10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 숫자 카드 2
     유형 : 이진 탐색, lower bound, upper bound
     시간 복잡도 : O(NlogN)
     난이도 : 보통
     시간 : 1h 30m
     uri : https://www.acmicpc.net/problem/10816
     날짜 : 22.11.30
     refer : https://st-lab.tistory.com/267
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints); // NLogN
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] ints1 = new int[m];
        for (int i = 0; i < m; i++) {
            ints1[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ints1) { // N
            int start = 0;
            int end = n - 1;
            while (start <= end) { // LogN
                int index = (start + end) / 2;
                if (ints[index] < i) {
                    start = index + 1;
                } else {
                    end = index - 1;
                }
            }
            int lowerBound = start;
            end = n - 1;
            while (start <= end) {
                int index = (start + end) / 2;
                if (ints[index] <= i) {
                    start = index + 1;
                } else {
                    end = index - 1;
                }
            }
            // start == upperBound
            sb.append(start - lowerBound).append(" ");
        }
        System.out.println(sb);
    }
    /*
    10  9 -5 2 3 4 5 -10
    7   7 2  2 3 5 5 0
    10  7 2  3 5 5 5 2
    -10 -10 2 3 3 6 7 10 10 10
    3 7 5 6

    8 9
    9 9
    10 9

    0 9 4
    5 9 7
    8 9 8
    9 9
     */
}
