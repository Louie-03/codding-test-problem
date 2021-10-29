package acmicpc;

import java.util.Scanner;

public class No8958 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            String s = strings[i];
            char[] chars = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                chars[j] = s.charAt(j);
            }
            int count = 0;
            int score = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = chars[j];
                if (c == 'O') {
                    count++;
                    score += count;
                }else {
                    count = 0;
                }
            }
            System.out.println(score);
        }
    }
}
