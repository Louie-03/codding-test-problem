package acmicpc;

import java.util.Scanner;

public class No1712 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (b >= c) {
            System.out.println(-1);
        } else {
            int num = c - b;
            System.out.println(a / num + 1);
        }
    }
}
