package acmicpc.no1850;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 최대공약수
     유형 : 유클리드 호재법, 수학
     시간 복잡도 : O(max(logA, logB))
     난이도 : 매우 쉬움
     시간 : 25m
     uri : https://www.acmicpc.net/problem/1850
     날짜 : 22.12.12
     refer : https://imkh.dev/algorithm-gcd-lcm
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long gcd = getGcd(a, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd; i++) {
            sb.append('1');
        }
        System.out.println(sb);
    }

    private static long getGcd(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        while (max % min != 0) {
            long r = max % min;
            max = min;
            min = r;
        }
        return min;
    }
    /*
    a와 b의 최대공약수 만큼 1을 출력하면 된다.

    111111
    111111111

    1
    111
    1111

    111
    111
    111111

    1
    111
    11111

    111
    1111111

    111
    11111111
     */
}
