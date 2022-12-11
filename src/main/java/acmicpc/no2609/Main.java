package acmicpc.no2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 최대공약수와 최소공배수
     유형 : 브루트포스
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/2609
     날짜 : 22.11.5
     refer : https://imkh.dev/algorithm-gcd-lcm/
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (max % min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        int gcf = min;
        System.out.println(gcf); // 최대공약수 = 유클리드 호제법 사용
        System.out.println(a * b / gcf); // 최소공배수 = a * b / 최대공약수
    }
}
