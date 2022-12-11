package inflearn.ch4.학습회장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//    1. 학급 회장 https://cote.inflearn.com/contest/10/problem/04-01
//    O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] chars = br.readLine().toCharArray();

        int[] ints = new int[5];
        for (char c : chars) {
            ints[c - 65] += 1;
        }

        char result = ' ';
        int maxCount = 0;
        for (int i = 0; i < 5; i++) {
            int num = ints[i];
            if (maxCount < num) {
                maxCount = num;
                result = (char) (i + 65);
            }
        }
        System.out.println(result);
    }
}
