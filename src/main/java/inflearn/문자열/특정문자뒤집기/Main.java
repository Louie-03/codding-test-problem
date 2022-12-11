package inflearn.문자열.특정문자뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //    5. 특정 문자 뒤집기 https://cote.inflearn.com/contest/10/problem/01-05
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                list.add(i);
            }
        }

        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            Integer index1 = list.get(i);
            Integer index2 = list.get(size - 1 - i);
            char c1 = chars[index1];
            chars[index1] = chars[index2];
            chars[index2] = c1;
        }
        System.out.println(chars);
    }
}
