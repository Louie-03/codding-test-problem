package inflearn.ch4.모든아나그램찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

//    4. 모든 아나그램 찾기 https://cote.inflearn.com/contest/10/problem/04-04
//    슬라이딩 윈도우
//    O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sChars = br.readLine().toCharArray();
        char[] tChars = br.readLine().toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < tChars.length; i++) {
            sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0) + 1);
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        }

        int count = 0;
        if (sMap.equals(tMap)) {
            count++;
        }

        for (int i = 1; i <= sChars.length - tChars.length; i++) {
            char sChar = sChars[i - 1];
            sMap.put(sChars[i + tChars.length - 1],
                sMap.getOrDefault(sChars[i + tChars.length - 1], 0) + 1);
            Integer sValue = sMap.getOrDefault(sChar, 0);
            if (sValue <= 1) {
                sMap.remove(sChar);
            } else {
                sMap.put(sChar, sValue - 1);
            }

            if (sMap.equals(tMap)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
