package acmicpc.no1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
    문제 : 부분합
    유형 : 누적합, 투 포인터
    시간 복잡도 : O(N)
    난이도 : 조금 쉬움
    시간 : 15m
    uri : https://www.acmicpc.net/problem/1806
    날짜 : 22.11.22
    refer :
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = ints[0];
        int answer = Integer.MAX_VALUE;
        while (end < n) {
            if (s <= sum) {
                answer = Math.min(answer, end - start + 1);
                sum -= ints[start++];
                continue;
            }
            end++;
            if (end < n) {
                sum += ints[end];
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

}
