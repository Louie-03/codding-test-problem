package inflearn.재귀트리그래프.재귀함수를이용한이진수출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 재귀함수를 이용한 이진수 출력
     유형 : 재귀
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri :
     날짜 : 22.10.13
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        recursive2(i);
    }

    private static void recursive(int i, int v) {
        int pow = (int) Math.pow(2, v);
        if (i >= pow) {
            i -= pow;
            System.out.print(1);
        } else {
            System.out.print(0);
        }
        if (v != 0) {
            recursive(i, v - 1);
        }
    }

    private static void recursive2(int i) {
        if (i == 0) {
            return;
        }
        recursive2(i / 2);
        System.out.print(i % 2);
    }

//    8 4 2 1
//    2 3

}
