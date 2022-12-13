package acmicpc.no1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 팩토리얼 0의 개수
     유형 : 수학
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/1676
     날짜 : 22.12.13
     refer : https://st-lab.tistory.com/165
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        System.out.println(count);
    }
    /*
    500
    100 20 4

    100
    20 4

    125
    25 5 1

    31

    25
    5 1

    1~n 까지 5의 배수의 개수만 구하면 된다.
    5의 배수의 개수는 n / 5, n / 25, n / 125이다.
    -> 625는 n의 범위를 벗어나기 때문에 125까지만 나눈 몫을 더하면 됨
     */
}
