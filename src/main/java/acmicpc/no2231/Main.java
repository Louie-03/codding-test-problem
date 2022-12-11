package acmicpc.no2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 분해합
     유형 : 브루트포스
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/2231
     날짜 : 22.11.5
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(getMinConstructor(n));
    }

    private static int getMinConstructor(int n) {
        for (int i = n - String.valueOf(n).length() * 9; i < n; i++) {
            int sum = i;
            for (char c : String.valueOf(i).toCharArray()) {
                sum += c - 48;
            }
            if (n == sum) {
                return i;
            }
        }
        return 0;
    }
    /*
    생성자는 (n - n의 자릿수 * 9) 이상이어야한다.

     */
}
