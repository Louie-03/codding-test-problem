package acmicpc;

import java.util.Scanner;

public class No1978 {

    public static int no1978(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (isNotOne(number) && isDecimal(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isDecimal(int number) {
        for (int j = 2; j < number; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotOne(int number) {
        return number != 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] numbers = new int[t];
        for (int i = 0; i < t; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println(No1978.no1978(numbers));
    }
}