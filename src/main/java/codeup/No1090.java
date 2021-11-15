package codeup;

import java.util.Scanner;

public class No1090 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        int r = scanner.nextInt();
        int n = scanner.nextInt();

        for (int i = 0; i < n - 1; i++) {
            a *= r;
        }
        System.out.println(a);
    }
}
