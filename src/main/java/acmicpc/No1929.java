package acmicpc;

import java.util.Scanner;

public class No1929 {

    private static boolean isDecimal(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        if (m == 1) {
            m = 2;
        }
        int n = sc.nextInt();
        for (int i = m; i <= n; i++) {
            if (isDecimal(i)) {
                System.out.println(i);
            }
        }
    }
}
