package inflearn.재귀트리그래프.팩토리얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 팩토리얼
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
        int n = Integer.parseInt(br.readLine());
//        recursive(n, n);
//        recursive2(1, n, 1);
        System.out.println(recursive3(n));
    }

    private static void recursive(int n, int answer) {
        if (n == 1) {
            System.out.println(answer);
        } else {
            recursive(n - 1, answer * (n - 1));
        }
    }

    private static void recursive2(int index, int n, int answer) {
        if (index != n) {
            recursive2(index + 1, n, answer * (index + 1));
        } else {
            System.out.println(answer);
        }
    }

    private static int recursive3(int n) {
        if (n == 1) {
            return 1;
        }
        return n * recursive3(n - 1);
    }
}
