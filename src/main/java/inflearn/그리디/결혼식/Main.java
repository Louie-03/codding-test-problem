package inflearn.그리디.결혼식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 결혼식
     유형 : 그리디
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://cote.inflearn.com/contest/10/problem/09-03
     날짜 : 22.10.24
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73414?category=questionDetail&tab=community
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[72];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                ints[j]++;
            }
        }

        int max = 0;
        for (int anInt : ints) {
            max = Math.max(max, anInt);
        }
        System.out.println(max);
    }

}
