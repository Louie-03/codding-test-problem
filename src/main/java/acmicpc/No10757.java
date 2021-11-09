package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        String strA = strings[0];
        String strB = strings[1];

        int maxLength = Math.max(strA.length(), strB.length());
        int[] result = new int[maxLength + 1];
        int[] a = new int[maxLength + 1];
        int[] b = new int[maxLength + 1];

        for (int i = strA.length() - 1; i >= 0; i--) {
            int index = strA.length() - 1 - i;
            a[index] = strA.charAt(i) - '0';
        }


        for (int i = strB.length() - 1; i >= 0; i--) {
            int index = strB.length() - 1 - i;
            b[index] = strB.charAt(i) - '0';
        }

        for (int i = 0; i < maxLength; i++) {
            int sum = a[i] + b[i];
            result[i] += sum % 10;
            result[i + 1] = sum / 10;
        }

        boolean check = true;
        for (int i = maxLength; i >= 0; i--) {
            if (check && result[i] == 0) {
                continue;
            }
            check = false;
            System.out.print(result[i]);
        }
    }
}
