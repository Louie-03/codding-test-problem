package acmicpc.no10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 수 정렬하기 3
     유형 : 정렬
     시간 복잡도 : O(N)
     난이도 : 보통
     시간 : 30m
     uri : https://www.acmicpc.net/problem/10989
     날짜 : 22.12.10
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] countArray = new int[10001];
        for (int i = 0; i < n; i++) {
            countArray[Integer.parseInt(br.readLine())]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
