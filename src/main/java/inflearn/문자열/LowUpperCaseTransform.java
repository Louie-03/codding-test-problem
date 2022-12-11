package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LowUpperCaseTransform {

//    2. 대소문자 변환 https://cote.inflearn.com/contest/10/problem/01-02
//    A ~ Z = 65 ~ 90
//    a ~ z = 97 ~ 122
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        String s = br.readLine();
        for (char c : s.toCharArray()) {
            if (isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));

            }
        }
        System.out.println(sb);
    }

    private static boolean isUpperCase(char c) {
        if (65 <= c && c <= 90) {
            return true;
        }
        return false;
    }
}
