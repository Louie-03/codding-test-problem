package doit.ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1BinarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] ints = {5, 7, 15, 28, 29, 31, 39, 58, 68, 70, 95};
        System.out.println(binarySearch(x, ints));
    }

    private static int binarySearch(int x, int[] ints) {
        int length = ints.length;
        int start = 0;
        int end = length - 1;
        int n = (int) (Math.log(length) / Math.log(2));
        for (int i = 0; i <= n; i++) {
            int index = (start + end) / 2;
            int num = ints[index];
            if (num == x) {
                return index;
            }
            if (num < x) {
                start = index + 1;
            }
            if (num > x) {
                end = index - 1;
            }
        }
        return -1;
    }
}
