package codeup;

import java.util.Scanner;

public class No1091 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        int n = scanner.nextInt();

        for (int i = 0; i < n - 1; i++) {
            a = a * m + d;
        }
        System.out.println(a);
    }
}
