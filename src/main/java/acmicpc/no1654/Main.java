package acmicpc.no1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 랜선 자르기
     유형 : 이분 탐색
     시간 복잡도 : O(NLogN)
     난이도 : 매우 어려움
     시간 : 2h
     uri : https://www.acmicpc.net/problem/1654
     날짜 : 22.12.2
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ints = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            int i1 = Integer.parseInt(br.readLine());
            ints[i] = i1;
            max = Math.max(max, i1);
        }
        long min = 0;
        long answer = 0;
        while (min <= max) {
            long index = (min + max) / 2;
            if (index == 0) {
                min++;
                max++;
                continue;
            }
            long count = 0;
            for (int anInt : ints) {
                count += anInt / index;
            }
            if (count >= m) {
                answer = Math.max(answer, index);
                min = index + 1;
            }
            if (count < m) {
                max = index - 1;
            }
        }
        System.out.println(answer);
    }
}
    /*
    logN(31) K(10000)

    n개는 못만드는데 n개보다 큰 개수의 전선은 만들 수 있는지? 없는 것 같다.
    4 1
    300
    100
    100
    300
     */
