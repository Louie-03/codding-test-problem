package codeup;

import java.util.Scanner;

public class No1092 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int i = 1;
        while (!(i % num1 == 0 && i % num2 == 0 && i % num3 == 0)) {
            i++;
        }
        System.out.println(i);
    }
}
