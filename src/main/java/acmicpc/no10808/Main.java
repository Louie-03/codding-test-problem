package acmicpc.no10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /*
     문제 : 알파벳 개수
     유형 : 해시
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://www.acmicpc.net/problem/10808
     날짜 : 22.12.10
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            sb.append(map.getOrDefault((char) i, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
