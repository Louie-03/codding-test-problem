package acmicpc.no1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 회의실 배정
     유형 : 그리디, 활동 선택 문제
     시간 복잡도 : O(NlogN)
     난이도 : 쉬움
     시간 : 20m
     uri : https://www.acmicpc.net/problem/1931
     날짜 : 22.11.9
     refer : https://st-lab.tistory.com/145
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ints[i][0] = Integer.parseInt(st.nextToken());
            ints[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints, (ints1, ints2) -> {
            if (ints1[1] == ints2[1]) {
                return ints1[0] - ints2[0];
            }
            return ints1[1] - ints2[1];
        });
        int time = 0;
        int answer = 0;
        for (int[] anInt : ints) {
            if (anInt[0] >= time) {
                answer++;
                time = anInt[1];
            }
        }
        System.out.println(answer);
    }
}
