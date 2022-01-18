package acmicpc;

import java.util.Scanner;

public class No2581 {

    public static int[] no2581(int m, int n) {
        int sum = 0;
        int min = 0;
        for (int i = m; i <= n; i++) {
            if (isDecimal(i)) {
                if (sum == 0) {
                    min = i;
                }
                sum += i;
            }
        }
        if (sum == 0) {
            return new int[]{-1};
        }
        return new int[]{sum, min};
    }

    private static boolean isDecimal(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        if (i != 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] results = No2581.no2581(m, n);
        for (int result : results) {
            System.out.println(result);
        }
    }
}
