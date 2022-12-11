package acmicpc.no11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 좌표 정렬하기 2
     유형 : 정렬
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://www.acmicpc.net/problem/11651
     날짜 : 22.12.10
     refer :
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
        Arrays.sort(ints, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        StringBuilder sb = new StringBuilder();
        for (int[] anInt : ints) {
            sb.append(anInt[0]).append(" ").append(anInt[1]).append("\n");
        }
        System.out.println(sb);
    }
}
