package acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No4948 {

    public static List<Integer> no4948(List<Integer> numbers) {
        List<Integer> countList = new ArrayList<>();
        for (Integer number : numbers) {
            countList.add(getDecimalCount(number));
        }
        return countList;
    }

    private static int getDecimalCount(int num) {
        int count = 0;
        for (int i = num + 1; i <= num * 2; i++) {
            if (isNotOne(i) && isDecimal(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isDecimal(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
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
        List<Integer> numList = new ArrayList<>();
        int num = sc.nextInt();
        while (num != 0) {
            numList.add(num);
            num = sc.nextInt();
        }
        No4948.no4948(numList).forEach(System.out::println);
    }
}