package acmicpc.no2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 조합 0의 개수
     유형 : 수학
     시간 복잡도 : O(?)
     난이도 : 보통
     시간 : 50m
     uri : https://www.acmicpc.net/problem/2004
     날짜 : 22.12.13
     refer : https://st-lab.tistory.com/166
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int count1 = getCount(n, 5) - getCount(n - r, 5) - getCount(r, 5);
        int count2 = getCount(n, 2) - getCount(n - r, 2) - getCount(r, 2);
        System.out.println(Math.min(count1, count2));
    }

    static int getCount(int num, int divide) {
        int count = 0;
        while (num >= divide) {
            num /= divide;
            count += num;
        }
        return count;
    }
}
