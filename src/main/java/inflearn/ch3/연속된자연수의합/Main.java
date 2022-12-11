package inflearn.ch3.연속된자연수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 5. 연속된 자연수의 합 https://cote.inflearn.com/contest/10/problem/03-05
     * 투포인터
     * O(N)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 0;
        while (n / 2 + 1 >= end) {
            if (sum == n) {
                count++;
                sum -= start++;
                sum += ++end;
            } else if (sum > n) {
                sum -= start++;
            } else {
                sum += ++end;
            }
        }
        System.out.println(count);
    }
}
