package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordInASentence {

//    3. 문장 속 단어 https://cote.inflearn.com/contest/10/problem/01-03
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] strings = s.split(" ");
        int maxLength = 0;
        String result = null;
        for (String string : strings) {
            int length = string.length();
            if (length > maxLength) {
                maxLength = length;
                result = string;
            }
        }
        System.out.println(result);
    }
}
